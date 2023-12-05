package ${PACKAGE}.${ENTITY_LOWERCASE}.api.delete.many;

import java.util.List;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestAware;

public interface DeleteMany${ENTITY}Coordinator extends CoordinatorRequestAware<List<${ID_TYPE}>> {
	
}
