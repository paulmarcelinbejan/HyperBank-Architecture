package ${PACKAGE}.${ENTITY_LOWERCASE}.api.delete.many;

import java.util.List;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface DeleteMany${ENTITY}Coordinator extends CoordinatorRequestAware<List<${ID_TYPE}>> {
	
	/**
	 * Delete many ${ENTITY_LOWERCASE} by IDs
	 */
	@Override
	void process(List<${ID_TYPE}> ids) throws FunctionalException, TechnicalException;
	
}
