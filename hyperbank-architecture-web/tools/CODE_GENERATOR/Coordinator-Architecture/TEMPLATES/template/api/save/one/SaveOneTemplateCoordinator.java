package ${PACKAGE}.${ENTITY_LOWERCASE}.api.save.one;

import ${PACKAGE}.${ENTITY_LOWERCASE}.dto.${ENTITY}Response;
import ${PACKAGE}.${ENTITY_LOWERCASE}.dto.${ENTITY}SaveRequest;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestResponseAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface SaveOne${ENTITY}Coordinator extends CoordinatorRequestResponseAware<${ENTITY}SaveRequest, ${ENTITY}Response> {
	
	/**
	 * Save ${ENTITY_LOWERCASE} by request
	 */
	@Override
	${ENTITY}Response process(${ENTITY}SaveRequest request) throws FunctionalException, TechnicalException;
	
}
