package ${PACKAGE}.${ENTITY_LOWERCASE}.api.find.many;

import java.util.List;

import ${PACKAGE}.${ENTITY_LOWERCASE}.entity.${ENTITY};

import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceInputOutputAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface FindMany${ENTITY}Service extends ServiceInputOutputAware<List<${ID_TYPE}>, List<${ENTITY}>> {

	/**
	 * Find many ${ENTITY_LOWERCASE} by IDs
	 */
	@Override
	List<${ENTITY}> execute(List<${ID_TYPE}> ids) throws FunctionalException, TechnicalException;
	
}
