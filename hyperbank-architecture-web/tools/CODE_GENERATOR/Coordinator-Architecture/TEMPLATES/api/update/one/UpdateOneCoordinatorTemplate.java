package ${PACKAGE}.${ENTITY_LOWERCASE}.api.update.one;

import ${PACKAGE}.${ENTITY_LOWERCASE}.dto.${ENTITY}Response;
import ${PACKAGE}.${ENTITY_LOWERCASE}.dto.${ENTITY}UpdateRequest;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestResponseAware;

public interface UpdateOne${ENTITY}Coordinator extends CoordinatorRequestResponseAware<${ENTITY}UpdateRequest, ${ENTITY}Response> {
	
}
