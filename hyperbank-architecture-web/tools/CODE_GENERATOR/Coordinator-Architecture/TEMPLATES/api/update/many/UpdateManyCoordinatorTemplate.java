package ${PACKAGE}.${ENTITY_LOWERCASE}.api.update.many;

import java.util.List;

import ${PACKAGE}.${ENTITY_LOWERCASE}.dto.${ENTITY}Response;
import ${PACKAGE}.${ENTITY_LOWERCASE}.dto.${ENTITY}UpdateRequest;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestResponseAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface UpdateMany${ENTITY}Coordinator extends CoordinatorRequestResponseAware<List<${ENTITY}UpdateRequest>, List<${ENTITY}Response>> {
	
	/**
	 * Update many ${ENTITY_LOWERCASE} by requests
	 */
	@Override
	List<${ENTITY}Response> process(List<${ENTITY}UpdateRequest> requests) throws FunctionalException, TechnicalException;
	
}
