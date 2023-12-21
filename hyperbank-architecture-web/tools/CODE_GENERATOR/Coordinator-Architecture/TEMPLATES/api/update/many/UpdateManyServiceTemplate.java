package ${PACKAGE}.${ENTITY_LOWERCASE}.api.update.many;

import java.util.List;

import ${PACKAGE}.${ENTITY_LOWERCASE}.entity.${ENTITY};

import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceInputOutputAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface UpdateMany${ENTITY}Service extends ServiceInputOutputAware<List<${ENTITY}>, List<${ENTITY}>> {

	/**
	 * Update many ${ENTITY_LOWERCASE}
	 */
	@Override
	List<${ENTITY}> execute(List<${ENTITY}> ${ENTITY_LOWERCASE}) throws FunctionalException, TechnicalException;
	
}
