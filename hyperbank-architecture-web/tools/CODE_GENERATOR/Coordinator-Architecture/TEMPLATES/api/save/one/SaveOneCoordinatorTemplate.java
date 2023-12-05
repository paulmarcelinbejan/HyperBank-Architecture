package ${PACKAGE}.${ENTITY_LOWERCASE}.api.save.one;

import ${PACKAGE}.${ENTITY_LOWERCASE}.dto.${ENTITY}Response;
import ${PACKAGE}.${ENTITY_LOWERCASE}.dto.${ENTITY}SaveRequest;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestResponseAware;

public interface SaveOne${ENTITY}Coordinator extends CoordinatorRequestResponseAware<${ENTITY}SaveRequest, ${ENTITY}Response> {
	
}
