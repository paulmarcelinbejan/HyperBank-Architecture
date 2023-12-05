package ${PACKAGE}.${ENTITY_LOWERCASE}.api.update.many;

import java.util.List;

import ${PACKAGE}.${ENTITY_LOWERCASE}.dto.${ENTITY}Response;
import ${PACKAGE}.${ENTITY_LOWERCASE}.dto.${ENTITY}UpdateRequest;
import ${PACKAGE}.${ENTITY_LOWERCASE}.entity.${ENTITY};
import ${PACKAGE}.${ENTITY_LOWERCASE}.mapper.EntitiesToDtos${ENTITY}Mapper;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorFull;

@Coordinator
public class UpdateMany${ENTITY}CoordinatorImpl extends CoordinatorFull<List<${ENTITY}UpdateRequest>, List<${ENTITY}>, List<${ENTITY}>, List<${ENTITY}Response>> implements UpdateMany${ENTITY}Coordinator {

	public UpdateMany${ENTITY}CoordinatorImpl(
			${ENTITY}UpdateRequestsValidator validator,
			UpdateMany${ENTITY}Mapper mapperInput, 
			UpdateMany${ENTITY}Service service,
			EntitiesToDtos${ENTITY}Mapper mapperOutput) {
		super(validator, mapperInput, service, mapperOutput);
	}
	
}
