package ${PACKAGE}.${ENTITY_LOWERCASE}.api.delete.many;

import java.util.List;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorWithoutMappings;
import io.github.paulmarcelinbejan.coordinator.architecture.validator.id.base.${ID_TYPE}IdsValidator;

@Coordinator
public class DeleteMany${ENTITY}CoordinatorImpl extends CoordinatorWithoutMappings<List<${ID_TYPE}>> implements DeleteMany${ENTITY}Coordinator {

	public DeleteMany${ENTITY}CoordinatorImpl(
			${ID_TYPE}IdsValidator validator,
			DeleteMany${ENTITY}Service service) {
		super(validator, service);
	}
	
}
