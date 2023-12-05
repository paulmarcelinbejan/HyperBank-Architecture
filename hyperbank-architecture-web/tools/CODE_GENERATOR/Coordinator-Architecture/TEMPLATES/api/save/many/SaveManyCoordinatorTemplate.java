package ${PACKAGE}.${ENTITY_LOWERCASE}.api.save.many;

import java.util.List;

import ${PACKAGE}.${ENTITY_LOWERCASE}.dto.${ENTITY}Response;
import ${PACKAGE}.${ENTITY_LOWERCASE}.dto.${ENTITY}SaveRequest;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestResponseAware;

public interface SaveMany${ENTITY}Coordinator extends CoordinatorRequestResponseAware<List<${ENTITY}SaveRequest>, List<${ENTITY}Response>> {
	
}
