package ${PACKAGE}.${ENTITY_LOWERCASE}.api.update.many;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import com.hyperbank.architecture.web.mapper.config.HyperBankMapperConfig;
import ${PACKAGE}.${ENTITY_LOWERCASE}.api.update.one.UpdateOne${ENTITY}Mapper;
import ${PACKAGE}.${ENTITY_LOWERCASE}.dto.${ENTITY}UpdateRequest;
import ${PACKAGE}.${ENTITY_LOWERCASE}.entity.${ENTITY};

import io.github.paulmarcelinbejan.coordinator.architecture.mapper.input.MapperInput;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

@Mapper(config = HyperBankMapperConfig.class, 
		uses = { UpdateOne${ENTITY}Mapper.class } )
public interface UpdateMany${ENTITY}Mapper extends 
	MapperInput<List<${ENTITY}UpdateRequest>, List<${ENTITY}>> {
	
	@Override
	@IterableMapping(qualifiedByName = "fromUpdateRequestToDomain")
	List<${ENTITY}> toDomain(List<${ENTITY}UpdateRequest> request) throws FunctionalException, TechnicalException;
	
}