package ${PACKAGE}.${ENTITY_LOWERCASE}.api.save.one;

import ${PACKAGE}.${ENTITY_LOWERCASE}.dto.${ENTITY}SaveRequest;

import io.github.paulmarcelinbejan.coordinator.architecture.validator.jakarta.JakartaBaseValidator;

public interface SaveOneRequest${ENTITY}Validator extends JakartaBaseValidator<${ENTITY}SaveRequest> {
	
}
