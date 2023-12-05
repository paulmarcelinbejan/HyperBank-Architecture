package ${PACKAGE}.${ENTITY_LOWERCASE}.api.update.one;

import ${PACKAGE}.${ENTITY_LOWERCASE}.dto.${ENTITY}Response;
import ${PACKAGE}.${ENTITY_LOWERCASE}.dto.${ENTITY}UpdateRequest;
import ${PACKAGE}.${ENTITY_LOWERCASE}.entity.${ENTITY};
import ${PACKAGE}.${ENTITY_LOWERCASE}.mapper.EntityToDto${ENTITY}Mapper;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorFull;

@Coordinator
public class UpdateOne${ENTITY}CoordinatorImpl extends CoordinatorFull<${ENTITY}UpdateRequest, ${ENTITY}, ${ENTITY}, ${ENTITY}Response> implements UpdateOne${ENTITY}Coordinator {

	public UpdateOne${ENTITY}CoordinatorImpl(
			UpdateOneRequest${ENTITY}Validator validator,
			UpdateOne${ENTITY}Mapper mapperInput, 
			UpdateOne${ENTITY}Service service,
			EntityToDto${ENTITY}Mapper mapperOutput) {
		super(validator, mapperInput, service, mapperOutput);
	}
	
}
