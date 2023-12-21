package ${PACKAGE}.${ENTITY_LOWERCASE}.api.delete.one;

import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceInputAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface DeleteOne${ENTITY}Service extends ServiceInputAware<${ID_TYPE}> {

	/**
	 * Delete ${ENTITY_LOWERCASE} by ID
	 */
	@Override
	void execute(${ID_TYPE} id) throws FunctionalException, TechnicalException;
	
}
