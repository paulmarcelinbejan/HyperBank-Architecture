package ${PACKAGE}.${ENTITY_LOWERCASE}.api.delete.one;

import com.hyperbank.architecture.web.validator.id.base.${ID_TYPE}IdValidator;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorWithoutMappings;

@Coordinator
public class DeleteOne${ENTITY}CoordinatorImpl extends CoordinatorWithoutMappings<${ID_TYPE}> implements DeleteOne${ENTITY}Coordinator {

	public DeleteOne${ENTITY}CoordinatorImpl(
			${ID_TYPE}IdValidator validator,
			DeleteOne${ENTITY}Service service) {
		super(validator, service);
	}
	
}
