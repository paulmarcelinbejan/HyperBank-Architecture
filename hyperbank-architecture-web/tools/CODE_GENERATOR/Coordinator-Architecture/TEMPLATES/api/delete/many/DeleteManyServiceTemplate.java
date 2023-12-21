package ${PACKAGE}.${ENTITY_LOWERCASE}.api.delete.many;

import java.util.List;

import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceInputAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface DeleteMany${ENTITY}Service extends ServiceInputAware<List<${ID_TYPE}>> {

	/**
	 * Delete many ${ENTITY_LOWERCASE} by IDs
	 */
	@Override
	void execute(List<${ID_TYPE}> ids) throws FunctionalException, TechnicalException;
	
}
