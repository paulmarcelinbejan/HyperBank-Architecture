#!/bin/zsh

readInputVariables() {
    # Read input variables
    echo "Enter TEMPLATES DIRECTORY: "
    read TEMPLATES_DIRECTORY
    echo "Enter ENTITY: "
    read ENTITY
    echo "Enter PACKAGE: "
    read PACKAGE
    echo "Enter ID_TYPE: "
    read ID_TYPE
    echo "Enter PROJECT DIRECTORY: "
    read OUTPUT_DIRECTORY
}

createEntityVariants() {
    # Create variants of Entity to use for package, type, variable,
    ENTITY_LOWERCASE=${ENTITY:l}
    #ENTITY_UPPERCASE=${ENTITY:u}
    local entity_first_char=${ENTITY[1,1]}
    local entity_rest_chars=${ENTITY[2,-1]}
    ENTITY_LOWERCAMELCASE="${entity_first_char:l}${entity_rest_chars}"
}

replacePlaceholders() {
    local from="$1"
    local to="$2"

    # Read implementation file, replace variables with placeholders, then write output file
    sed -e "s/\${PACKAGE}/${PACKAGE}/g" \
        -e "s/\${ID_TYPE}/${ID_TYPE}/g" \
        -e "s/\${ENTITY}/${ENTITY}/g" \
        -e "s/\${ENTITY_LOWERCASE}/${ENTITY_LOWERCASE}/g" \
        -e "s/\${ENTITY_LOWERCAMELCASE}/${ENTITY_LOWERCAMELCASE}/g" \
        ${from} > ${to}
}

generate_impl() {
    local source_dir="$1"
    local target_dir="$2"
    
    # Create the target directory if it doesn't exist
    mkdir -p "$target_dir"

    # Loop through files and directories in the source directory
    for source_item in "$source_dir"/*; do

        local source_base_name=$(basename "$source_item")
        local target_base_name

        if [[ $source_base_name == *Template* ]]; then
            # Replace "Template" with the value of ENTITY in source_base_name
            target_base_name="${source_base_name//Template/$ENTITY}"
        elif [[ $source_base_name == *template* ]]; then
            # Replace "template" with the value of ENTITY_LOWERCASE in source_base_name
            target_base_name="${source_base_name//template/$ENTITY_LOWERCASE}"
        elif [[ $source_base_name == *templateLc* ]]; then
            # Replace "templateLc" with the value of ENTITY_LOWERCAMELCASE in source_base_name
            target_base_name="${source_base_name//templateLc/$ENTITY_LOWERCAMELCASE}"
        else
            # If neither "Template" nor "template" nor "templateLc" is found, keep the original name
            target_base_name="$source_base_name"
        fi

        local target_item="$target_dir/$target_base_name"

        if [ -d "$source_item" ]; then

            # Recursively process subdirectories
            generate_impl "$source_item" "$target_item"

        elif [ -f "$source_item" ]; then

            # Check if the file is in the "dto" or "entity" folder
            local parent_folder_name=$(basename "$(dirname "$source_item")")

            if [[ ($parent_folder_name != "dto" && $parent_folder_name != "entity") || (! -e "$target_item") ]]; then
                replacePlaceholders "$source_item" "$target_item"
                echo "${target_item} created correctly"
            fi

        fi

        # Check if the sed command was executed correctly
        if [ $? -eq 0 ]; then
          echo "${target_item} created correctly"
        else
          echo "Error creating ${target_item} from ${source_item}"
        fi
        
        echo

    done
}

logCodeGeneratorCompleted() {
    echo -e "\033[1;32mScript completed!\033[0m"
    echo -e "\033[1;31mPlease consider to check the Mapper before using it.\033[0m"
}

#INPUT
if [ $# -eq 5 ]; then
    # If 5 arguments are provided
    TEMPLATES_DIRECTORY="$1"
    ENTITY="$2"
    PACKAGE="$3"
    ID_TYPE="$4"
    OUTPUT_DIRECTORY="$5"
else
    readInputVariables
fi

echo

createEntityVariants

# Start processing from the TEMPLATES_DIRECTORY
generate_impl "$TEMPLATES_DIRECTORY/template" "$OUTPUT_DIRECTORY/$ENTITY_LOWERCASE"

logCodeGeneratorCompleted
