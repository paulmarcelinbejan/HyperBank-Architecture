package ${PACKAGE}.${ENTITY_LOWERCASE}.api.save.many;

import java.util.List;

import ${PACKAGE}.${ENTITY_LOWERCASE}.dto.${ENTITY}Response;
import ${PACKAGE}.${ENTITY_LOWERCASE}.dto.${ENTITY}SaveRequest;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestResponseAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface SaveMany${ENTITY}Coordinator extends CoordinatorRequestResponseAware<List<${ENTITY}SaveRequest>, List<${ENTITY}Response>> {
	
	/**
	 * Save many ${ENTITY_LOWERCASE} by requests
	 */
	@Override
	List<${ENTITY}Response> process(List<${ENTITY}SaveRequest> requests) throws FunctionalException, TechnicalException;
	
}
