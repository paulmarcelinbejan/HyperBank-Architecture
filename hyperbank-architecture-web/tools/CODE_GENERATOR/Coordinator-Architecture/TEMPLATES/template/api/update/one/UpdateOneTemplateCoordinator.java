package ${PACKAGE}.${ENTITY_LOWERCASE}.api.update.one;

import ${PACKAGE}.${ENTITY_LOWERCASE}.dto.${ENTITY}Response;
import ${PACKAGE}.${ENTITY_LOWERCASE}.dto.${ENTITY}UpdateRequest;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestResponseAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface UpdateOne${ENTITY}Coordinator extends CoordinatorRequestResponseAware<${ENTITY}UpdateRequest, ${ENTITY}Response> {
	
	/**
	 * Update ${ENTITY_LOWERCASE} by request
	 */
	@Override
	${ENTITY}Response process(${ENTITY}UpdateRequest request) throws FunctionalException, TechnicalException;
	
}
