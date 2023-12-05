package ${PACKAGE}.${ENTITY_LOWERCASE}.api.find.many;

import java.util.List;

import ${PACKAGE}.${ENTITY_LOWERCASE}.dto.${ENTITY}Response;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestResponseAware;

public interface FindMany${ENTITY}Coordinator extends CoordinatorRequestResponseAware<List<${ID_TYPE}>, List<${ENTITY}Response>> {
	
}
