#!/bin/zsh

# Regular Colors
GREEN='\033[0;92m'
BLUE='\033[1;94m'
RED='\033[0;31m'
YELLOW='\033[0;33m'
COLOR_OFF='\033[0m'

printHorizontalLine() {
    echo -e "$YELLOW-------------------------------------------------------------------------------------------------------- $COLOR_OFF"
}

readInputVariablesFromInput() {
    echo -e "${YELLOW}Enter TEMPLATES DIRECTORY: ${COLOR_OFF}"
    read TEMPLATES_DIRECTORY
    echo -e "${YELLOW}Enter ENTITY: ${COLOR_OFF}"
    read ENTITY
    echo -e "${YELLOW}Enter PACKAGE: ${COLOR_OFF}"
    read PACKAGE
    echo -e "${YELLOW}Enter ID_TYPE: ${COLOR_OFF}"
    read ID_TYPE
    echo -e "${YELLOW}Enter PROJECT DIRECTORY: ${COLOR_OFF}"
    read PROJECT_DIRECTORY

    echo
    printHorizontalLine
    echo

}

createEntityVariants() {
    # Create variants of Entity to use for package, type, variable,
    ENTITY_LOWERCASE=${ENTITY:l}
    #ENTITY_UPPERCASE=${ENTITY:u}
    local entity_first_char=${ENTITY[1, 1]}
    local entity_rest_chars=${ENTITY[2, -1]}
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
        ${from} >${to}
}

generate_impl() {
    local source_dir="$1"
    local target_dir="$2"

    # Create the target directory if it doesn't exist
    mkdir -p "$target_dir"

    # Loop through files and directories in the source directory
    for source_item in "$source_dir"/*; do

        local source_base_name=$(basename "$source_item")

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
                echo -e "${GREEN}$(basename "$target_item") created correctly! $COLOR_OFF"
            fi

        fi

        # Check if the sed command was executed correctly
        if [ $? -eq 0 ]; then
            echo -e "${GREEN}$(basename "$target_item") created correctly! $COLOR_OFF"
        else
            echo -e "${RED}Error creating $(basename "$target_item") from ${source_item} !!! $COLOR_OFF"
        fi

        echo
        printHorizontalLine
        echo

    done
}

logCodeGeneratorCompleted() {
    echo -e "$GREEN Script completed! $COLOR_OFF"
    echo -e "$RED Please consider to check the Mapper before using it. $COLOR_OFF"
}

#-------------------------------------------------------(MAIN SCRIPT LOGIC)-------------------------------------------------------

readInputVariablesFromInput

createEntityVariants

# Start processing from the TEMPLATES_DIRECTORY
generate_impl "$TEMPLATES_DIRECTORY/template" "$PROJECT_DIRECTORY/$ENTITY_LOWERCASE"

logCodeGeneratorCompleted
