package ${PACKAGE}.${ENTITY_LOWERCASE}.api.find.all;

import java.util.List;

import ${PACKAGE}.${ENTITY_LOWERCASE}.dto.${ENTITY}Response;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorResponseAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface FindAll${ENTITY}Coordinator extends CoordinatorResponseAware<List<${ENTITY}Response>> {

	/**
	 * Find all ${ENTITY_LOWERCASE}
	 */
	@Override
	List<${ENTITY}Response> process() throws FunctionalException, TechnicalException;
	
}
