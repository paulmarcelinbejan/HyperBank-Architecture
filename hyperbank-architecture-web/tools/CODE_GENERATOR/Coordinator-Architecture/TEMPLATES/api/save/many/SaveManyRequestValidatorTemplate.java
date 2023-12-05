package ${PACKAGE}.${ENTITY_LOWERCASE}.api.save.many;

import java.util.List;

import ${PACKAGE}.${ENTITY_LOWERCASE}.dto.${ENTITY}SaveRequest;

import io.github.paulmarcelinbejan.coordinator.architecture.validator.jakarta.JakartaCollectionValidator;

public interface SaveManyRequest${ENTITY}Validator extends JakartaCollectionValidator<${ENTITY}SaveRequest, List<${ENTITY}SaveRequest>> {
	
}
