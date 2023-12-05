package ${PACKAGE}.${ENTITY_LOWERCASE}.api.update.many;

import java.util.List;

import ${PACKAGE}.${ENTITY_LOWERCASE}.dto.${ENTITY}Response;
import ${PACKAGE}.${ENTITY_LOWERCASE}.dto.${ENTITY}UpdateRequest;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestResponseAware;

public interface UpdateMany${ENTITY}Coordinator extends CoordinatorRequestResponseAware<List<${ENTITY}UpdateRequest>, List<${ENTITY}Response>> {
	
}
