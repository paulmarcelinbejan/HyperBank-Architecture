package ${PACKAGE}.${ENTITY_LOWERCASE}.api.save.many;

import java.util.List;

import ${PACKAGE}.${ENTITY_LOWERCASE}.dto.${ENTITY}Response;
import ${PACKAGE}.${ENTITY_LOWERCASE}.dto.${ENTITY}SaveRequest;
import ${PACKAGE}.${ENTITY_LOWERCASE}.entity.${ENTITY};
import ${PACKAGE}.${ENTITY_LOWERCASE}.mapper.EntitiesToDtos${ENTITY}Mapper;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorFull;

@Coordinator
public class SaveMany${ENTITY}CoordinatorImpl extends CoordinatorFull<List<${ENTITY}SaveRequest>, List<${ENTITY}>, List<${ENTITY}>, List<${ENTITY}Response>> implements SaveMany${ENTITY}Coordinator {

	public SaveMany${ENTITY}CoordinatorImpl(
			${ENTITY}SaveRequestsValidator validator,
			SaveMany${ENTITY}Mapper mapperInput, 
			SaveMany${ENTITY}Service service,
			EntitiesToDtos${ENTITY}Mapper mapperOutput) {
		super(validator, mapperInput, service, mapperOutput);
	}
	
}
