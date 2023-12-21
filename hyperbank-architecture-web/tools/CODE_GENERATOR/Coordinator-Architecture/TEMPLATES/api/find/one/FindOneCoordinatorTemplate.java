package ${PACKAGE}.${ENTITY_LOWERCASE}.api.find.one;

import ${PACKAGE}.${ENTITY_LOWERCASE}.dto.${ENTITY}Response;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestResponseAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface FindOne${ENTITY}Coordinator extends CoordinatorRequestResponseAware<${ID_TYPE}, ${ENTITY}Response> {
	
	/**
	 * Find ${ENTITY_LOWERCASE} by id
	 */
	@Override
	${ENTITY}Response process(${ID_TYPE} id) throws FunctionalException, TechnicalException;
	
}
