package ${PACKAGE}.${ENTITY_LOWERCASE}.api.save.one;

import ${PACKAGE}.${ENTITY_LOWERCASE}.dto.${ENTITY}Response;
import ${PACKAGE}.${ENTITY_LOWERCASE}.dto.${ENTITY}SaveRequest;
import ${PACKAGE}.${ENTITY_LOWERCASE}.entity.${ENTITY};
import ${PACKAGE}.${ENTITY_LOWERCASE}.mapper.EntityToDto${ENTITY}Mapper;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorFull;

@Coordinator
public class SaveOne${ENTITY}CoordinatorImpl extends CoordinatorFull<${ENTITY}SaveRequest, ${ENTITY}, ${ENTITY}, ${ENTITY}Response> implements SaveOne${ENTITY}Coordinator {

	public SaveOne${ENTITY}CoordinatorImpl(
			${ENTITY}SaveRequestValidator validator,
			SaveOne${ENTITY}Mapper mapperInput, 
			SaveOne${ENTITY}Service service,
			EntityToDto${ENTITY}Mapper mapperOutput) {
		super(validator, mapperInput, service, mapperOutput);
	}
	
}
