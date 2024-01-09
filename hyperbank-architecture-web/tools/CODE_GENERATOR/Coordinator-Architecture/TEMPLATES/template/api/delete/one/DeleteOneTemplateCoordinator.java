package ${PACKAGE}.${ENTITY_LOWERCASE}.api.delete.one;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface DeleteOne${ENTITY}Coordinator extends CoordinatorRequestAware<${ID_TYPE}> {
	
	/**
	 * Delete ${ENTITY_LOWERCASE} by ID
	 */
	@Override
	void process(${ID_TYPE} id) throws FunctionalException, TechnicalException;

}
