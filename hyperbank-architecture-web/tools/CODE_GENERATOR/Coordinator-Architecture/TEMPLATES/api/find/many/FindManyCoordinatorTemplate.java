package ${PACKAGE}.${ENTITY_LOWERCASE}.api.find.many;

import java.util.List;

import ${PACKAGE}.${ENTITY_LOWERCASE}.dto.${ENTITY}Response;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestResponseAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface FindMany${ENTITY}Coordinator extends CoordinatorRequestResponseAware<List<${ID_TYPE}>, List<${ENTITY}Response>> {

	/**
	 * Find many ${ENTITY_LOWERCASE} by IDs
	 */
	@Override
	List<${ENTITY}Response> process(List<${ID_TYPE}> ids) throws FunctionalException, TechnicalException;

}
