package ${PACKAGE}.${ENTITY_LOWERCASE}.api.save.many;

import java.util.List;

import ${PACKAGE}.${ENTITY_LOWERCASE}.entity.${ENTITY};

import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceInputOutputAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface SaveMany${ENTITY}Service extends ServiceInputOutputAware<List<${ENTITY}>, List<${ENTITY}>> {

	/**
	 * Save many ${ENTITY_LOWERCASE}
	 */
	@Override
	List<${ENTITY}> execute(List<${ENTITY}> ${ENTITY_LOWERCASE}) throws FunctionalException, TechnicalException;
	
}
