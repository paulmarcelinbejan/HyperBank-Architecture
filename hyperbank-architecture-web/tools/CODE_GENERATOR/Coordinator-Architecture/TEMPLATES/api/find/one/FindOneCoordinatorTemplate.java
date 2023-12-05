package ${PACKAGE}.${ENTITY_LOWERCASE}.api.find.one;

import ${PACKAGE}.${ENTITY_LOWERCASE}.dto.${ENTITY}Response;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestResponseAware;

public interface FindOne${ENTITY}Coordinator extends CoordinatorRequestResponseAware<${ID_TYPE}, ${ENTITY}Response> {
	
}
