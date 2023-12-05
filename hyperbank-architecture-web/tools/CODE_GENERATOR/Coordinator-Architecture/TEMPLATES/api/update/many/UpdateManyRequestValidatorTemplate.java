package ${PACKAGE}.${ENTITY_LOWERCASE}.api.update.many;

import java.util.List;

import ${PACKAGE}.${ENTITY_LOWERCASE}.dto.${ENTITY}UpdateRequest;

import io.github.paulmarcelinbejan.coordinator.architecture.validator.jakarta.JakartaCollectionValidator;

public interface ${ENTITY}UpdateRequestsValidator extends JakartaCollectionValidator<${ENTITY}UpdateRequest, List<${ENTITY}UpdateRequest>> {
	
}
