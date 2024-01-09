package ${PACKAGE}.${ENTITY_LOWERCASE}.api.save.one;

import ${PACKAGE}.${ENTITY_LOWERCASE}.entity.${ENTITY};

import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceInputOutputAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface SaveOne${ENTITY}Service extends ServiceInputOutputAware<${ENTITY}, ${ENTITY}> {

	/**
	 * Save ${ENTITY_LOWERCASE}
	 */
	@Override
	${ENTITY} execute(${ENTITY} ${ENTITY_LOWERCASE}) throws FunctionalException, TechnicalException;
	
}
