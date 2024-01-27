package ${PACKAGE}.${ENTITY_LOWERCASE}.api.delete.one;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorWithoutMappings;
import io.github.paulmarcelinbejan.coordinator.architecture.validator.id.base.${ID_TYPE}IdValidator;

@Coordinator
public class DeleteOne${ENTITY}CoordinatorImpl extends CoordinatorWithoutMappings<${ID_TYPE}> implements DeleteOne${ENTITY}Coordinator {

	public DeleteOne${ENTITY}CoordinatorImpl(
			${ID_TYPE}IdValidator validator,
			DeleteOne${ENTITY}Service service) {
		super(validator, service);
	}
	
}
