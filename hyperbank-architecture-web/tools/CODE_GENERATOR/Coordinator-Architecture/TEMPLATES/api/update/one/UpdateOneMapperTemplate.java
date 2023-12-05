package ${PACKAGE}.${ENTITY_LOWERCASE}.api.update.one;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import com.hyperbank.architecture.web.mapper.config.HyperBankMapperConfig;
import ${PACKAGE}.${ENTITY_LOWERCASE}.api.find.one.FindOne${ENTITY}Service;
import ${PACKAGE}.${ENTITY_LOWERCASE}.dto.${ENTITY}UpdateRequest;
import ${PACKAGE}.${ENTITY_LOWERCASE}.entity.${ENTITY};

import io.github.paulmarcelinbejan.coordinator.architecture.mapper.input.MapperInput;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

@Mapper(config = HyperBankMapperConfig.class)
public abstract class UpdateOne${ENTITY}Mapper implements 
	MapperInput<${ENTITY}UpdateRequest, ${ENTITY}> {
	
	@Autowired
	private FindOne${ENTITY}Service findOne${ENTITY}Service;
	
	@Override
	@Named("fromUpdateRequestToDomain")
	public ${ENTITY} toDomain(${ENTITY}UpdateRequest request) throws FunctionalException, TechnicalException {
		${ENTITY} ${ENTITY_LOWERCASE} = findOne${ENTITY}Service.execute(request.getId());
		return update${ENTITY}(request, ${ENTITY_LOWERCASE});
	}
	
	@Mapping(target = "id", ignore = true)
	public abstract ${ENTITY} update${ENTITY}(${ENTITY}UpdateRequest request, @MappingTarget ${ENTITY} ${ENTITY_LOWERCASE});
	
}