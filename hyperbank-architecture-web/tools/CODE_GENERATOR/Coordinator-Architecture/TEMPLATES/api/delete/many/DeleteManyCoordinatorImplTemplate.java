package ${PACKAGE}.${ENTITY_LOWERCASE}.api.delete.many;

import java.util.List;

import com.hyperbank.architecture.web.validator.id.base.${ID_TYPE}IdsValidator;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorWithoutMappings;

@Coordinator
public class DeleteMany${ENTITY}CoordinatorImpl extends CoordinatorWithoutMappings<List<${ID_TYPE}>> implements DeleteMany${ENTITY}Coordinator {

	public DeleteMany${ENTITY}CoordinatorImpl(
			${ID_TYPE}IdsValidator validator,
			DeleteMany${ENTITY}Service service) {
		super(validator, service);
	}
	
}
