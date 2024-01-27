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
    echo -e "${YELLOW}Enter PROJECT DIRECTORY: ${COLOR_OFF}"
    read PROJECT_DIRECTORY
    echo -e "${YELLOW}Enter ENTITY: ${COLOR_OFF}"
    read ENTITY
    echo -e "${YELLOW}Enter PACKAGE: ${COLOR_OFF}"
    read PACKAGE
    echo -e "${YELLOW}Enter ID_TYPE: ${COLOR_OFF}"
    read ID_TYPE
    echo -e "${YELLOW}Enter OUTPUT DIRECTORY: ${COLOR_OFF}"
    read OUTPUT_DIRECTORY

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
    sed -e "s/${PACKAGE}/\${PACKAGE}/g" \
        -e "s/${ID_TYPE}/\${ID_TYPE}/g" \
        -e "s/${ENTITY}/\${ENTITY}/g" \
        -e "s/${ENTITY_LOWERCASE}/\${ENTITY_LOWERCASE}/g" \
        -e "s/${ENTITY_LOWERCAMELCASE}/\${ENTITY_LOWERCAMELCASE}/g" \
        -e "s/\<${ENTITY}\>/\${ENTITY}/g" \
        -e "s/\<${ENTITY_LOWERCASE}\>/\${ENTITY_LOWERCASE}/g" \
        -e "s/\<${ENTITY_LOWERCAMELCASE}\>/\${ENTITY_LOWERCAMELCASE}/g" \
        ${from} >${to}
}

# Function to process files and directories recursively in order to create templates
generate_template() {
    local source_dir="$1"
    local target_dir="$2"

    # Create the target directory if it doesn't exist
    mkdir -p "$target_dir"

    # Loop through files and directories in the source directory
    for source_item in "$source_dir"/*; do

        local source_base_name=$(basename "$source_item")

        if [[ $source_base_name == *"${ENTITY}"* ]]; then
            # Replace ENTITY with "Template" in source_base_name
            target_base_name="${source_base_name//$ENTITY/Template}"
        elif [[ $source_base_name == *"${ENTITY_LOWERCASE}"* ]]; then
            # Replace ENTITY_LOWERCASE with "template" in source_base_name
            target_base_name="${source_base_name//$ENTITY_LOWERCASE/template}"
        elif [[ $source_base_name == *"${ENTITY_LOWERCASE}"* ]]; then
            # Replace ENTITY_LOWERCAMELCASE with "templateLc" in source_base_name
            target_base_name="${source_base_name//$ENTITY_LOWERCASE/templateLc}"
        else
            # If neither ENTITY nor ENTITY_LOWERCASE nor ENTITY_LOWERCAMELCASE is found, keep the original name
            target_base_name="$source_base_name"
        fi

        local target_item="$target_dir/$target_base_name"

        if [ -d "$source_item" ]; then

            # Recursively process subdirectories
            generate_template "$source_item" "$target_item"

        elif [ -f "$source_item" ]; then

            if [[ $source_dir == *"dto"* ]] || [[ $source_dir == *"entity"* ]]; then
                # Replace all characters between the first curly brackets and the last one with three new lines
                sed -n '/{/{p;q;};p' "$source_item" >"${target_item}.tmp" && echo $'\n\n\n}' >>"${target_item}.tmp"
                replacePlaceholders "${target_item}.tmp" "$target_item"
                rm "${target_item}.tmp"
            else
                replacePlaceholders "$source_item" "$target_item"
            fi

        fi

        # Check if the sed command was executed correctly
        if [ $? -eq 0 ]; then
            echo -e "$GREEN $(basename "$target_item") created correctly! $COLOR_OFF"
        else
            echo -e "$RED Error creating $(basename "$target_item") from ${source_item} !!! $COLOR_OFF"
        fi

        echo
        printHorizontalLine
        echo

    done
}

logCodeGeneratorCompleted() {
    echo -e "$GREEN Script completed! $COLOR_OFF"
    echo
    echo -e "$GREEN TEMPLATES generated correctly into: $OUTPUT_DIRECTORY ! $COLOR_OFF"
}

#-------------------------------------------------------(MAIN SCRIPT LOGIC)-------------------------------------------------------

readInputVariablesFromInput

createEntityVariants

# Start processing from the project directory
generate_template "$PROJECT_DIRECTORY/$ENTITY_LOWERCASE" "$OUTPUT_DIRECTORY/template"

logCodeGeneratorCompleted
