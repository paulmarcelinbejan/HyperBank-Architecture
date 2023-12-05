package ${PACKAGE}.${ENTITY_LOWERCASE}.api.find.all;

import java.util.List;

import ${PACKAGE}.${ENTITY_LOWERCASE}.dto.${ENTITY}Response;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorResponseAware;

public interface FindAll${ENTITY}Coordinator extends CoordinatorResponseAware<List<${ENTITY}Response>> {
	
}
