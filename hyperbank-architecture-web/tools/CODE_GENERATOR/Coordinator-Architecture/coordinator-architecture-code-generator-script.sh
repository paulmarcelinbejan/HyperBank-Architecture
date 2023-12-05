#!/bin/zsh

readInputVariables() {
    # Read input variables
    echo "Enter ENTITY: "
    read ENTITY
    echo "Enter PACKAGE: "
    read PACKAGE
    echo "Enter ID_TYPE: "
    read ID_TYPE
}

declareFolders() {
    # Declare folders
    ENTITY_FOLDER="entity"
    DTO_FOLDER="dto"
    CONTROLLER_FOLDER="controller"
    MAPPER_FOLDER="mapper"
    REPOSITORY_FOLDER="repository"
    API_FOLDER="api"
}

createEntityVariants() {
    # Create variants of Entity to use for package, type, variable,
    ENTITY_LOWERCASE=${ENTITY:l}
    #ENTITY_UPPERCASE=${ENTITY:u}
    entity_first_char=${ENTITY[1,1]}
    entity_rest_chars=${ENTITY[2,-1]}
    ENTITY_LOWERCAMELCASE="${entity_first_char:l}${entity_rest_chars}"
}

declareInputFiles() {
    # Common Input Files
    RestControllerTemplate="${SCRIPT_DIRECTORY}/${TEMPLATE_FOLDER}/${CONTROLLER_FOLDER}/RestControllerTemplate.java"
    EntityToDtoMapperTemplate="${SCRIPT_DIRECTORY}/${TEMPLATE_FOLDER}/${MAPPER_FOLDER}/EntityToDtoMapperTemplate.java"
    EntitiesToDtosMapperTemplate="${SCRIPT_DIRECTORY}/${TEMPLATE_FOLDER}/${MAPPER_FOLDER}/EntitiesToDtosMapperTemplate.java"
    RepositoryTemplate="${SCRIPT_DIRECTORY}/${TEMPLATE_FOLDER}/${REPOSITORY_FOLDER}/RepositoryTemplate.java"
    
    # Find One API Input Files
    FindOneCoordinatorImplTemplate="${SCRIPT_DIRECTORY}/${TEMPLATE_FOLDER}/${API_FOLDER}/find/one/FindOneCoordinatorImplTemplate.java"
    FindOneCoordinatorTemplate="${SCRIPT_DIRECTORY}/${TEMPLATE_FOLDER}/${API_FOLDER}/find/one/FindOneCoordinatorTemplate.java"
    FindOneServiceImplTemplate="${SCRIPT_DIRECTORY}/${TEMPLATE_FOLDER}/${API_FOLDER}/find/one/FindOneServiceImplTemplate.java"
    FindOneServiceTemplate="${SCRIPT_DIRECTORY}/${TEMPLATE_FOLDER}/${API_FOLDER}/find/one/FindOneServiceTemplate.java"
    
    # Find Many API Input Files
    FindManyCoordinatorImplTemplate="${SCRIPT_DIRECTORY}/${TEMPLATE_FOLDER}/${API_FOLDER}/find/many/FindManyCoordinatorImplTemplate.java"
    FindManyCoordinatorTemplate="${SCRIPT_DIRECTORY}/${TEMPLATE_FOLDER}/${API_FOLDER}/find/many/FindManyCoordinatorTemplate.java"
    FindManyServiceImplTemplate="${SCRIPT_DIRECTORY}/${TEMPLATE_FOLDER}/${API_FOLDER}/find/many/FindManyServiceImplTemplate.java"
    FindManyServiceTemplate="${SCRIPT_DIRECTORY}/${TEMPLATE_FOLDER}/${API_FOLDER}/find/many/FindManyServiceTemplate.java"
    
    # Find All API Input Files
    FindAllCoordinatorImplTemplate="${SCRIPT_DIRECTORY}/${TEMPLATE_FOLDER}/${API_FOLDER}/find/all/FindAllCoordinatorImplTemplate.java"
    FindAllCoordinatorTemplate="${SCRIPT_DIRECTORY}/${TEMPLATE_FOLDER}/${API_FOLDER}/find/all/FindAllCoordinatorTemplate.java"
    FindAllServiceImplTemplate="${SCRIPT_DIRECTORY}/${TEMPLATE_FOLDER}/${API_FOLDER}/find/all/FindAllServiceImplTemplate.java"
    FindAllServiceTemplate="${SCRIPT_DIRECTORY}/${TEMPLATE_FOLDER}/${API_FOLDER}/find/all/FindAllServiceTemplate.java"
    
    # Save One API Input Files
    SaveOneCoordinatorImplTemplate="${SCRIPT_DIRECTORY}/${TEMPLATE_FOLDER}/${API_FOLDER}/save/one/SaveOneCoordinatorImplTemplate.java"
    SaveOneCoordinatorTemplate="${SCRIPT_DIRECTORY}/${TEMPLATE_FOLDER}/${API_FOLDER}/save/one/SaveOneCoordinatorTemplate.java"
    SaveOneMapperTemplate="${SCRIPT_DIRECTORY}/${TEMPLATE_FOLDER}/${API_FOLDER}/save/one/SaveOneMapperTemplate.java"
    SaveOneRequestValidatorImplTemplate="${SCRIPT_DIRECTORY}/${TEMPLATE_FOLDER}/${API_FOLDER}/save/one/SaveOneRequestValidatorImplTemplate.java"
    SaveOneRequestValidatorTemplate="${SCRIPT_DIRECTORY}/${TEMPLATE_FOLDER}/${API_FOLDER}/save/one/SaveOneRequestValidatorTemplate.java"
    SaveOneServiceImplTemplate="${SCRIPT_DIRECTORY}/${TEMPLATE_FOLDER}/${API_FOLDER}/save/one/SaveOneServiceImplTemplate.java"
    SaveOneServiceTemplate="${SCRIPT_DIRECTORY}/${TEMPLATE_FOLDER}/${API_FOLDER}/save/one/SaveOneServiceTemplate.java"
    
    # Save Many API Input Files
    SaveManyCoordinatorImplTemplate="${SCRIPT_DIRECTORY}/${TEMPLATE_FOLDER}/${API_FOLDER}/save/many/SaveManyCoordinatorImplTemplate.java"
    SaveManyCoordinatorTemplate="${SCRIPT_DIRECTORY}/${TEMPLATE_FOLDER}/${API_FOLDER}/save/many/SaveManyCoordinatorTemplate.java"
    SaveManyMapperTemplate="${SCRIPT_DIRECTORY}/${TEMPLATE_FOLDER}/${API_FOLDER}/save/many/SaveManyMapperTemplate.java"
    SaveManyRequestValidatorImplTemplate="${SCRIPT_DIRECTORY}/${TEMPLATE_FOLDER}/${API_FOLDER}/save/many/SaveManyRequestValidatorImplTemplate.java"
    SaveManyRequestValidatorTemplate="${SCRIPT_DIRECTORY}/${TEMPLATE_FOLDER}/${API_FOLDER}/save/many/SaveManyRequestValidatorTemplate.java"
    SaveManyServiceImplTemplate="${SCRIPT_DIRECTORY}/${TEMPLATE_FOLDER}/${API_FOLDER}/save/many/SaveManyServiceImplTemplate.java"
    SaveManyServiceTemplate="${SCRIPT_DIRECTORY}/${TEMPLATE_FOLDER}/${API_FOLDER}/save/many/SaveManyServiceTemplate.java"
    
    # Update One API Input Files
    UpdateOneCoordinatorImplTemplate="${SCRIPT_DIRECTORY}/${TEMPLATE_FOLDER}/${API_FOLDER}/update/one/UpdateOneCoordinatorImplTemplate.java"
    UpdateOneCoordinatorTemplate="${SCRIPT_DIRECTORY}/${TEMPLATE_FOLDER}/${API_FOLDER}/update/one/UpdateOneCoordinatorTemplate.java"
    UpdateOneMapperTemplate="${SCRIPT_DIRECTORY}/${TEMPLATE_FOLDER}/${API_FOLDER}/update/one/UpdateOneMapperTemplate.java"
    UpdateOneRequestValidatorImplTemplate="${SCRIPT_DIRECTORY}/${TEMPLATE_FOLDER}/${API_FOLDER}/update/one/UpdateOneRequestValidatorImplTemplate.java"
    UpdateOneRequestValidatorTemplate="${SCRIPT_DIRECTORY}/${TEMPLATE_FOLDER}/${API_FOLDER}/update/one/UpdateOneRequestValidatorTemplate.java"
    UpdateOneServiceImplTemplate="${SCRIPT_DIRECTORY}/${TEMPLATE_FOLDER}/${API_FOLDER}/update/one/UpdateOneServiceImplTemplate.java"
    UpdateOneServiceTemplate="${SCRIPT_DIRECTORY}/${TEMPLATE_FOLDER}/${API_FOLDER}/update/one/UpdateOneServiceTemplate.java"
    
    # Update Many API Input Files
    UpdateManyCoordinatorImplTemplate="${SCRIPT_DIRECTORY}/${TEMPLATE_FOLDER}/${API_FOLDER}/update/many/UpdateManyCoordinatorImplTemplate.java"
    UpdateManyCoordinatorTemplate="${SCRIPT_DIRECTORY}/${TEMPLATE_FOLDER}/${API_FOLDER}/update/many/UpdateManyCoordinatorTemplate.java"
    UpdateManyMapperTemplate="${SCRIPT_DIRECTORY}/${TEMPLATE_FOLDER}/${API_FOLDER}/update/many/UpdateManyMapperTemplate.java"
    UpdateManyRequestValidatorImplTemplate="${SCRIPT_DIRECTORY}/${TEMPLATE_FOLDER}/${API_FOLDER}/update/many/UpdateManyRequestValidatorImplTemplate.java"
    UpdateManyRequestValidatorTemplate="${SCRIPT_DIRECTORY}/${TEMPLATE_FOLDER}/${API_FOLDER}/update/many/UpdateManyRequestValidatorTemplate.java"
    UpdateManyServiceImplTemplate="${SCRIPT_DIRECTORY}/${TEMPLATE_FOLDER}/${API_FOLDER}/update/many/UpdateManyServiceImplTemplate.java"
    UpdateManyServiceTemplate="${SCRIPT_DIRECTORY}/${TEMPLATE_FOLDER}/${API_FOLDER}/update/many/UpdateManyServiceTemplate.java"
    
    # Delete One API Input Files
    DeleteOneCoordinatorImplTemplate="${SCRIPT_DIRECTORY}/${TEMPLATE_FOLDER}/${API_FOLDER}/delete/one/DeleteOneCoordinatorImplTemplate.java"
    DeleteOneCoordinatorTemplate="${SCRIPT_DIRECTORY}/${TEMPLATE_FOLDER}/${API_FOLDER}/delete/one/DeleteOneCoordinatorTemplate.java"
    DeleteOneServiceImplTemplate="${SCRIPT_DIRECTORY}/${TEMPLATE_FOLDER}/${API_FOLDER}/delete/one/DeleteOneServiceImplTemplate.java"
    DeleteOneServiceTemplate="${SCRIPT_DIRECTORY}/${TEMPLATE_FOLDER}/${API_FOLDER}/delete/one/DeleteOneServiceTemplate.java"
    
    # Delete Many API Input Files
    DeleteManyCoordinatorImplTemplate="${SCRIPT_DIRECTORY}/${TEMPLATE_FOLDER}/${API_FOLDER}/delete/many/DeleteManyCoordinatorImplTemplate.java"
    DeleteManyCoordinatorTemplate="${SCRIPT_DIRECTORY}/${TEMPLATE_FOLDER}/${API_FOLDER}/delete/many/DeleteManyCoordinatorTemplate.java"
    DeleteManyServiceImplTemplate="${SCRIPT_DIRECTORY}/${TEMPLATE_FOLDER}/${API_FOLDER}/delete/many/DeleteManyServiceImplTemplate.java"
    DeleteManyServiceTemplate="${SCRIPT_DIRECTORY}/${TEMPLATE_FOLDER}/${API_FOLDER}/delete/many/DeleteManyServiceTemplate.java"
    
    TEMPLATES=(
        "${RestControllerTemplate}"
        "${EntityToDtoMapperTemplate}"
        "${EntitiesToDtosMapperTemplate}"
        "${RepositoryTemplate}"
        "${FindOneCoordinatorImplTemplate}"
        "${FindOneCoordinatorTemplate}"
        "${FindOneServiceImplTemplate}"
        "${FindOneServiceTemplate}"
        "${FindManyCoordinatorImplTemplate}"
        "${FindManyCoordinatorTemplate}"
        "${FindManyServiceImplTemplate}"
        "${FindManyServiceTemplate}"
        "${FindAllCoordinatorImplTemplate}"
        "${FindAllCoordinatorTemplate}"
        "${FindAllServiceImplTemplate}"
        "${FindAllServiceTemplate}"
        "${SaveOneCoordinatorImplTemplate}"
        "${SaveOneCoordinatorTemplate}"
        "${SaveOneMapperTemplate}"
        "${SaveOneRequestValidatorImplTemplate}"
        "${SaveOneRequestValidatorTemplate}"
        "${SaveOneServiceImplTemplate}"
        "${SaveOneServiceTemplate}"
        "${SaveManyCoordinatorImplTemplate}"
        "${SaveManyCoordinatorTemplate}"
        "${SaveManyMapperTemplate}"
        "${SaveManyRequestValidatorImplTemplate}"
        "${SaveManyRequestValidatorTemplate}"
        "${SaveManyServiceImplTemplate}"
        "${SaveManyServiceTemplate}"
        "${UpdateOneCoordinatorImplTemplate}"
        "${UpdateOneCoordinatorTemplate}"
        "${UpdateOneMapperTemplate}"
        "${UpdateOneRequestValidatorImplTemplate}"
        "${UpdateOneRequestValidatorTemplate}"
        "${UpdateOneServiceImplTemplate}"
        "${UpdateOneServiceTemplate}"
        "${UpdateManyCoordinatorImplTemplate}"
        "${UpdateManyCoordinatorTemplate}"
        "${UpdateManyMapperTemplate}"
        "${UpdateManyRequestValidatorImplTemplate}"
        "${UpdateManyRequestValidatorTemplate}"
        "${UpdateManyServiceImplTemplate}"
        "${UpdateManyServiceTemplate}"
        "${DeleteOneCoordinatorImplTemplate}"
        "${DeleteOneCoordinatorTemplate}"
        "${DeleteOneServiceImplTemplate}"
        "${DeleteOneServiceTemplate}"
        "${DeleteManyCoordinatorImplTemplate}"
        "${DeleteManyCoordinatorTemplate}"
        "${DeleteManyServiceImplTemplate}"
        "${DeleteManyServiceTemplate}"
    )
}

checkIfTemplatesArePresent() {
    # Check if all the templates are present in the SCRIPT_DIRECTORY
    for template in "${TEMPLATES[@]}"; do
      if [ ! -f "$template" ]; then
        echo "Error: Input file $template does not exist in the directory."
        exit 1
      fi
    done
}

logParameters() {
    # Logs
    echo
    echo This scipt is configured with:
    echo Entity: $ENTITY
    echo Package: $PACKAGE
    echo Id type: $ID_TYPE
}

createDirectories() {
    # Create directories
    mkdir -p $GENERATED_FOLDER
    mkdir -p $GENERATED_FOLDER/$ENTITY_LOWERCASE
    mkdir -p $GENERATED_FOLDER/$ENTITY_LOWERCASE/$ENTITY_FOLDER
    mkdir -p $GENERATED_FOLDER/$ENTITY_LOWERCASE/$DTO_FOLDER
    mkdir -p $GENERATED_FOLDER/$ENTITY_LOWERCASE/$CONTROLLER_FOLDER
    mkdir -p $GENERATED_FOLDER/$ENTITY_LOWERCASE/$MAPPER_FOLDER
    mkdir -p $GENERATED_FOLDER/$ENTITY_LOWERCASE/$REPOSITORY_FOLDER
    mkdir -p $GENERATED_FOLDER/$ENTITY_LOWERCASE/$API_FOLDER
    mkdir -p $GENERATED_FOLDER/$ENTITY_LOWERCASE/$API_FOLDER/find
    mkdir -p $GENERATED_FOLDER/$ENTITY_LOWERCASE/$API_FOLDER/find/one
    mkdir -p $GENERATED_FOLDER/$ENTITY_LOWERCASE/$API_FOLDER/find/many
    mkdir -p $GENERATED_FOLDER/$ENTITY_LOWERCASE/$API_FOLDER/find/all
    mkdir -p $GENERATED_FOLDER/$ENTITY_LOWERCASE/$API_FOLDER/save
    mkdir -p $GENERATED_FOLDER/$ENTITY_LOWERCASE/$API_FOLDER/save/one
    mkdir -p $GENERATED_FOLDER/$ENTITY_LOWERCASE/$API_FOLDER/save/many
    mkdir -p $GENERATED_FOLDER/$ENTITY_LOWERCASE/$API_FOLDER/update
    mkdir -p $GENERATED_FOLDER/$ENTITY_LOWERCASE/$API_FOLDER/update/one
    mkdir -p $GENERATED_FOLDER/$ENTITY_LOWERCASE/$API_FOLDER/update/many
    mkdir -p $GENERATED_FOLDER/$ENTITY_LOWERCASE/$API_FOLDER/delete
    mkdir -p $GENERATED_FOLDER/$ENTITY_LOWERCASE/$API_FOLDER/delete/one
    mkdir -p $GENERATED_FOLDER/$ENTITY_LOWERCASE/$API_FOLDER/delete/many
}

declareOutputFiles() {
    # Common Input Files
    RestControllerOutput="${SCRIPT_DIRECTORY}/${GENERATED_FOLDER}/$ENTITY_LOWERCASE/${CONTROLLER_FOLDER}/${ENTITY}RestController.java"
    EntityToDtoMapperOutput="${SCRIPT_DIRECTORY}/${GENERATED_FOLDER}/$ENTITY_LOWERCASE/${MAPPER_FOLDER}/EntityToDto${ENTITY}Mapper.java"
    EntitiesToDtosMapperOutput="${SCRIPT_DIRECTORY}/${GENERATED_FOLDER}/$ENTITY_LOWERCASE/${MAPPER_FOLDER}/EntitiesToDtos${ENTITY}Mapper.java"
    RepositoryOutput="${SCRIPT_DIRECTORY}/${GENERATED_FOLDER}/$ENTITY_LOWERCASE/${REPOSITORY_FOLDER}/${ENTITY}Repository.java"
    
    # Find One API Input Files
    FindOneCoordinatorImplOutput="${SCRIPT_DIRECTORY}/${GENERATED_FOLDER}/$ENTITY_LOWERCASE/${API_FOLDER}/find/one/FindOne${ENTITY}CoordinatorImpl.java"
    FindOneCoordinatorOutput="${SCRIPT_DIRECTORY}/${GENERATED_FOLDER}/$ENTITY_LOWERCASE/${API_FOLDER}/find/one/FindOne${ENTITY}Coordinator.java"
    FindOneServiceImplOutput="${SCRIPT_DIRECTORY}/${GENERATED_FOLDER}/$ENTITY_LOWERCASE/${API_FOLDER}/find/one/FindOne${ENTITY}ServiceImpl.java"
    FindOneServiceOutput="${SCRIPT_DIRECTORY}/${GENERATED_FOLDER}/$ENTITY_LOWERCASE/${API_FOLDER}/find/one/FindOne${ENTITY}Service.java"
    
    # Find Many API Input Files
    FindManyCoordinatorImplOutput="${SCRIPT_DIRECTORY}/${GENERATED_FOLDER}/$ENTITY_LOWERCASE/${API_FOLDER}/find/many/FindMany${ENTITY}CoordinatorImpl.java"
    FindManyCoordinatorOutput="${SCRIPT_DIRECTORY}/${GENERATED_FOLDER}/$ENTITY_LOWERCASE/${API_FOLDER}/find/many/FindMany${ENTITY}Coordinator.java"
    FindManyServiceImplOutput="${SCRIPT_DIRECTORY}/${GENERATED_FOLDER}/$ENTITY_LOWERCASE/${API_FOLDER}/find/many/FindMany${ENTITY}ServiceImpl.java"
    FindManyServiceOutput="${SCRIPT_DIRECTORY}/${GENERATED_FOLDER}/$ENTITY_LOWERCASE/${API_FOLDER}/find/many/FindMany${ENTITY}Service.java"
    
    # Find All API Input Files
    FindAllCoordinatorImplOutput="${SCRIPT_DIRECTORY}/${GENERATED_FOLDER}/$ENTITY_LOWERCASE/${API_FOLDER}/find/all/FindAll${ENTITY}CoordinatorImpl.java"
    FindAllCoordinatorOutput="${SCRIPT_DIRECTORY}/${GENERATED_FOLDER}/$ENTITY_LOWERCASE/${API_FOLDER}/find/all/FindAll${ENTITY}Coordinator.java"
    FindAllServiceImplOutput="${SCRIPT_DIRECTORY}/${GENERATED_FOLDER}/$ENTITY_LOWERCASE/${API_FOLDER}/find/all/FindAll${ENTITY}ServiceImpl.java"
    FindAllServiceOutput="${SCRIPT_DIRECTORY}/${GENERATED_FOLDER}/$ENTITY_LOWERCASE/${API_FOLDER}/find/all/FindAll${ENTITY}Service.java"
    
    # Save One API Input Files
    SaveOneCoordinatorImplOutput="${SCRIPT_DIRECTORY}/${GENERATED_FOLDER}/$ENTITY_LOWERCASE/${API_FOLDER}/save/one/SaveOne${ENTITY}CoordinatorImpl.java"
    SaveOneCoordinatorOutput="${SCRIPT_DIRECTORY}/${GENERATED_FOLDER}/$ENTITY_LOWERCASE/${API_FOLDER}/save/one/SaveOne${ENTITY}Coordinator.java"
    SaveOneMapperOutput="${SCRIPT_DIRECTORY}/${GENERATED_FOLDER}/$ENTITY_LOWERCASE/${API_FOLDER}/save/one/SaveOne${ENTITY}Mapper.java"
    SaveOneRequestValidatorImplOutput="${SCRIPT_DIRECTORY}/${GENERATED_FOLDER}/$ENTITY_LOWERCASE/${API_FOLDER}/save/one/SaveOne${ENTITY}RequestValidatorImpl.java"
    SaveOneRequestValidatorOutput="${SCRIPT_DIRECTORY}/${GENERATED_FOLDER}/$ENTITY_LOWERCASE/${API_FOLDER}/save/one/SaveOne${ENTITY}RequestValidator.java"
    SaveOneServiceImplOutput="${SCRIPT_DIRECTORY}/${GENERATED_FOLDER}/$ENTITY_LOWERCASE/${API_FOLDER}/save/one/SaveOne${ENTITY}ServiceImpl.java"
    SaveOneServiceOutput="${SCRIPT_DIRECTORY}/${GENERATED_FOLDER}/$ENTITY_LOWERCASE/${API_FOLDER}/save/one/SaveOne${ENTITY}Service.java"
    
    # Save Many API Input Files
    SaveManyCoordinatorImplOutput="${SCRIPT_DIRECTORY}/${GENERATED_FOLDER}/$ENTITY_LOWERCASE/${API_FOLDER}/save/many/SaveMany${ENTITY}CoordinatorImpl.java"
    SaveManyCoordinatorOutput="${SCRIPT_DIRECTORY}/${GENERATED_FOLDER}/$ENTITY_LOWERCASE/${API_FOLDER}/save/many/SaveMany${ENTITY}Coordinator.java"
    SaveManyMapperOutput="${SCRIPT_DIRECTORY}/${GENERATED_FOLDER}/$ENTITY_LOWERCASE/${API_FOLDER}/save/many/SaveMany${ENTITY}Mapper.java"
    SaveManyRequestValidatorImplOutput="${SCRIPT_DIRECTORY}/${GENERATED_FOLDER}/$ENTITY_LOWERCASE/${API_FOLDER}/save/many/SaveMany${ENTITY}RequestValidatorImpl.java"
    SaveManyRequestValidatorOutput="${SCRIPT_DIRECTORY}/${GENERATED_FOLDER}/$ENTITY_LOWERCASE/${API_FOLDER}/save/many/SaveMany${ENTITY}RequestValidator.java"
    SaveManyServiceImplOutput="${SCRIPT_DIRECTORY}/${GENERATED_FOLDER}/$ENTITY_LOWERCASE/${API_FOLDER}/save/many/SaveMany${ENTITY}ServiceImpl.java"
    SaveManyServiceOutput="${SCRIPT_DIRECTORY}/${GENERATED_FOLDER}/$ENTITY_LOWERCASE/${API_FOLDER}/save/many/SaveMany${ENTITY}Service.java"
    
    # Update One API Input Files
    UpdateOneCoordinatorImplOutput="${SCRIPT_DIRECTORY}/${GENERATED_FOLDER}/$ENTITY_LOWERCASE/${API_FOLDER}/update/one/UpdateOne${ENTITY}CoordinatorImpl.java"
    UpdateOneCoordinatorOutput="${SCRIPT_DIRECTORY}/${GENERATED_FOLDER}/$ENTITY_LOWERCASE/${API_FOLDER}/update/one/UpdateOne${ENTITY}Coordinator.java"
    UpdateOneMapperOutput="${SCRIPT_DIRECTORY}/${GENERATED_FOLDER}/$ENTITY_LOWERCASE/${API_FOLDER}/update/one/UpdateOne${ENTITY}Mapper.java"
    UpdateOneRequestValidatorImplOutput="${SCRIPT_DIRECTORY}/${GENERATED_FOLDER}/$ENTITY_LOWERCASE/${API_FOLDER}/update/one/UpdateOne${ENTITY}RequestValidatorImpl.java"
    UpdateOneRequestValidatorOutput="${SCRIPT_DIRECTORY}/${GENERATED_FOLDER}/$ENTITY_LOWERCASE/${API_FOLDER}/update/one/UpdateOne${ENTITY}RequestValidator.java"
    UpdateOneServiceImplOutput="${SCRIPT_DIRECTORY}/${GENERATED_FOLDER}/$ENTITY_LOWERCASE/${API_FOLDER}/update/one/UpdateOne${ENTITY}ServiceImpl.java"
    UpdateOneServiceOutput="${SCRIPT_DIRECTORY}/${GENERATED_FOLDER}/$ENTITY_LOWERCASE/${API_FOLDER}/update/one/UpdateOne${ENTITY}Service.java"
    
    # Update Many API Input Files
    UpdateManyCoordinatorImplOutput="${SCRIPT_DIRECTORY}/${GENERATED_FOLDER}/$ENTITY_LOWERCASE/${API_FOLDER}/update/many/UpdateMany${ENTITY}CoordinatorImpl.java"
    UpdateManyCoordinatorOutput="${SCRIPT_DIRECTORY}/${GENERATED_FOLDER}/$ENTITY_LOWERCASE/${API_FOLDER}/update/many/UpdateMany${ENTITY}Coordinator.java"
    UpdateManyMapperOutput="${SCRIPT_DIRECTORY}/${GENERATED_FOLDER}/$ENTITY_LOWERCASE/${API_FOLDER}/update/many/UpdateMany${ENTITY}Mapper.java"
    UpdateManyRequestValidatorImplOutput="${SCRIPT_DIRECTORY}/${GENERATED_FOLDER}/$ENTITY_LOWERCASE/${API_FOLDER}/update/many/UpdateMany${ENTITY}RequestValidatorImpl.java"
    UpdateManyRequestValidatorOutput="${SCRIPT_DIRECTORY}/${GENERATED_FOLDER}/$ENTITY_LOWERCASE/${API_FOLDER}/update/many/UpdateMany${ENTITY}RequestValidator.java"
    UpdateManyServiceImplOutput="${SCRIPT_DIRECTORY}/${GENERATED_FOLDER}/$ENTITY_LOWERCASE/${API_FOLDER}/update/many/UpdateMany${ENTITY}ServiceImpl.java"
    UpdateManyServiceOutput="${SCRIPT_DIRECTORY}/${GENERATED_FOLDER}/$ENTITY_LOWERCASE/${API_FOLDER}/update/many/UpdateMany${ENTITY}Service.java"
    
    # Delete One API Input Files
    DeleteOneCoordinatorImplOutput="${SCRIPT_DIRECTORY}/${GENERATED_FOLDER}/$ENTITY_LOWERCASE/${API_FOLDER}/delete/one/DeleteOne${ENTITY}CoordinatorImpl.java"
    DeleteOneCoordinatorOutput="${SCRIPT_DIRECTORY}/${GENERATED_FOLDER}/$ENTITY_LOWERCASE/${API_FOLDER}/delete/one/DeleteOne${ENTITY}Coordinator.java"
    DeleteOneServiceImplOutput="${SCRIPT_DIRECTORY}/${GENERATED_FOLDER}/$ENTITY_LOWERCASE/${API_FOLDER}/delete/one/DeleteOne${ENTITY}ServiceImpl.java"
    DeleteOneServiceOutput="${SCRIPT_DIRECTORY}/${GENERATED_FOLDER}/$ENTITY_LOWERCASE/${API_FOLDER}/delete/one/DeleteOne${ENTITY}Service.java"
    
    # Delete Many API Input Files
    DeleteManyCoordinatorImplOutput="${SCRIPT_DIRECTORY}/${GENERATED_FOLDER}/$ENTITY_LOWERCASE/${API_FOLDER}/delete/many/DeleteMany${ENTITY}CoordinatorImpl.java"
    DeleteManyCoordinatorOutput="${SCRIPT_DIRECTORY}/${GENERATED_FOLDER}/$ENTITY_LOWERCASE/${API_FOLDER}/delete/many/DeleteMany${ENTITY}Coordinator.java"
    DeleteManyServiceImplOutput="${SCRIPT_DIRECTORY}/${GENERATED_FOLDER}/$ENTITY_LOWERCASE/${API_FOLDER}/delete/many/DeleteMany${ENTITY}ServiceImpl.java"
    DeleteManyServiceOutput="${SCRIPT_DIRECTORY}/${GENERATED_FOLDER}/$ENTITY_LOWERCASE/${API_FOLDER}/delete/many/DeleteMany${ENTITY}Service.java"
    
    OUTPUTS=(
        "${RestControllerOutput}"
        "${EntityToDtoMapperOutput}"
        "${EntitiesToDtosMapperOutput}"
        "${RepositoryOutput}"
        "${FindOneCoordinatorImplOutput}"
        "${FindOneCoordinatorOutput}"
        "${FindOneServiceImplOutput}"
        "${FindOneServiceOutput}"
        "${FindManyCoordinatorImplOutput}"
        "${FindManyCoordinatorOutput}"
        "${FindManyServiceImplOutput}"
        "${FindManyServiceOutput}"
        "${FindAllCoordinatorImplOutput}"
        "${FindAllCoordinatorOutput}"
        "${FindAllServiceImplOutput}"
        "${FindAllServiceOutput}"
        "${SaveOneCoordinatorImplOutput}"
        "${SaveOneCoordinatorOutput}"
        "${SaveOneMapperOutput}"
        "${SaveOneRequestValidatorImplOutput}"
        "${SaveOneRequestValidatorOutput}"
        "${SaveOneServiceImplOutput}"
        "${SaveOneServiceOutput}"
        "${SaveManyCoordinatorImplOutput}"
        "${SaveManyCoordinatorOutput}"
        "${SaveManyMapperOutput}"
        "${SaveManyRequestValidatorImplOutput}"
        "${SaveManyRequestValidatorOutput}"
        "${SaveManyServiceImplOutput}"
        "${SaveManyServiceOutput}"
        "${UpdateOneCoordinatorImplOutput}"
        "${UpdateOneCoordinatorOutput}"
        "${UpdateOneMapperOutput}"
        "${UpdateOneRequestValidatorImplOutput}"
        "${UpdateOneRequestValidatorOutput}"
        "${UpdateOneServiceImplOutput}"
        "${UpdateOneServiceOutput}"
        "${UpdateManyCoordinatorImplOutput}"
        "${UpdateManyCoordinatorOutput}"
        "${UpdateManyMapperOutput}"
        "${UpdateManyRequestValidatorImplOutput}"
        "${UpdateManyRequestValidatorOutput}"
        "${UpdateManyServiceImplOutput}"
        "${UpdateManyServiceOutput}"
        "${DeleteOneCoordinatorImplOutput}"
        "${DeleteOneCoordinatorOutput}"
        "${DeleteOneServiceImplOutput}"
        "${DeleteOneServiceOutput}"
        "${DeleteManyCoordinatorImplOutput}"
        "${DeleteManyCoordinatorOutput}"
        "${DeleteManyServiceImplOutput}"
        "${DeleteManyServiceOutput}"
    )
}

replacePlaceholders() {
    # Calculate the length of the TEMPLATES array
    templates_length=${#TEMPLATES[@]}
    
    echo
    
    # Iterate over templates
    for (( index=1; index<=templates_length; index++ )); do
    
      template="${TEMPLATES[index]}"
      output="${OUTPUTS[index]}"
    
      templateFileName="${template##*/}"
      outputFileName="${output##*/}"
      echo "Creating ${outputFileName} from ${templateFileName}"
    
      # Read template file, replace placeholders with variables, then write output file
      sed -e "s/\${PACKAGE}/${PACKAGE}/g" \
          -e "s/\${ID_TYPE}/${ID_TYPE}/g" \
          -e "s/\${ENTITY}/${ENTITY}/g" \
          -e "s/\${ENTITY_LOWERCASE}/${ENTITY_LOWERCASE}/g" \
          -e "s/\${ENTITY_LOWERCAMELCASE}/${ENTITY_LOWERCAMELCASE}/g" \
          ${template} > ${output}

      # Check if the sed command was executed correctly
      if [ $? -eq 0 ]; then
        echo "${outputFileName} created correctly"
      else
        echo "Error creating ${outputFileName} from ${templateFileName}"
      fi
    
      echo
    
    done
}

logCodeGeneratorCompleted() {
    echo -e "\033[1;32mScript completed!\033[0m"
    echo -e "\033[1;31mPlease consider to check the Mapper before using it.\033[0m"
}

# Main script logic
main() {

    # Get the directory path of the script
    SCRIPT_DIRECTORY=$(pwd)

    echo SCRIPT DIRECTORY : $SCRIPT_DIRECTORY

    GENERATED_FOLDER="GENERATED"
    TEMPLATE_FOLDER="TEMPLATES"

    readInputVariables
    declareFolders
    createEntityVariants

    declareInputFiles
    checkIfTemplatesArePresent

    logParameters

    createDirectories
    declareOutputFiles

    replacePlaceholders
    logCodeGeneratorCompleted

}

main

