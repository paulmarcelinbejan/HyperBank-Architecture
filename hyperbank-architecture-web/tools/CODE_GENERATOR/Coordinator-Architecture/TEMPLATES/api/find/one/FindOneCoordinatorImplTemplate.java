package ${PACKAGE}.${ENTITY_LOWERCASE}.api.find.one;

import com.hyperbank.architecture.web.validator.id.base.${ID_TYPE}IdValidator;
import ${PACKAGE}.${ENTITY_LOWERCASE}.dto.${ENTITY}Response;
import ${PACKAGE}.${ENTITY_LOWERCASE}.entity.${ENTITY};
import ${PACKAGE}.${ENTITY_LOWERCASE}.mapper.EntityToDto${ENTITY}Mapper;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorWithoutInputMapping;

@Coordinator
public class FindOne${ENTITY}CoordinatorImpl extends CoordinatorWithoutInputMapping<${ID_TYPE}, ${ENTITY}, ${ENTITY}Response> implements FindOne${ENTITY}Coordinator {

	public FindOne${ENTITY}CoordinatorImpl(
			${ID_TYPE}IdValidator validator,
			EntityToDto${ENTITY}Mapper mapper, 
			FindOne${ENTITY}Service service) {
		super(validator, service, mapper);
	}
	
}
