package ${PACKAGE}.${ENTITY_LOWERCASE}.api.find.one;

import ${PACKAGE}.${ENTITY_LOWERCASE}.entity.${ENTITY};

import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceInputOutputAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;

public interface FindOne${ENTITY}Service extends ServiceInputOutputAware<${ID_TYPE}, ${ENTITY}> {

	/**
	 * Find ${ENTITY_LOWERCASE} by ID
	 */
	@Override
	${ENTITY} execute(${ID_TYPE} id) throws FunctionalException;
	
}
