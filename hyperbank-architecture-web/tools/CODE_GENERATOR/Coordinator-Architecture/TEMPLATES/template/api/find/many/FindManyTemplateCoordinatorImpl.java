package ${PACKAGE}.${ENTITY_LOWERCASE}.api.find.many;

import java.util.List;

import ${PACKAGE}.${ENTITY_LOWERCASE}.dto.${ENTITY}Response;
import ${PACKAGE}.${ENTITY_LOWERCASE}.entity.${ENTITY};
import ${PACKAGE}.${ENTITY_LOWERCASE}.mapper.EntitiesToDtos${ENTITY}Mapper;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorWithoutInputMapping;
import io.github.paulmarcelinbejan.coordinator.architecture.validator.id.base.${ID_TYPE}IdsValidator;

@Coordinator
public class FindMany${ENTITY}CoordinatorImpl extends CoordinatorWithoutInputMapping<List<${ID_TYPE}>, List<${ENTITY}>, List<${ENTITY}Response>> implements FindMany${ENTITY}Coordinator {

	public FindMany${ENTITY}CoordinatorImpl(
			${ID_TYPE}IdsValidator validator,
			FindMany${ENTITY}Service service,
			EntitiesToDtos${ENTITY}Mapper mapper) {
		super(validator, service, mapper);
	}
	
}
