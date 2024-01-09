package ${PACKAGE}.${ENTITY_LOWERCASE}.api.find.all;

import java.util.List;

import ${PACKAGE}.${ENTITY_LOWERCASE}.dto.${ENTITY}Response;
import ${PACKAGE}.${ENTITY_LOWERCASE}.entity.${ENTITY};
import ${PACKAGE}.${ENTITY_LOWERCASE}.mapper.EntitiesToDtos${ENTITY}Mapper;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorServiceResponse;

@Coordinator
public class FindAll${ENTITY}CoordinatorImpl extends CoordinatorServiceResponse<List<${ENTITY}>, List<${ENTITY}Response>> implements FindAll${ENTITY}Coordinator {

	public FindAll${ENTITY}CoordinatorImpl(
			FindAll${ENTITY}Service service,
			EntitiesToDtos${ENTITY}Mapper mapper) {
		super(service, mapper);
	}
	
}
