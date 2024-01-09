package ${PACKAGE}.${ENTITY_LOWERCASE}.api.save.many;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import com.hyperbank.architecture.web.mapper.config.HyperBankMapperConfig;
import ${PACKAGE}.${ENTITY_LOWERCASE}.api.save.one.SaveOne${ENTITY}Mapper;
import ${PACKAGE}.${ENTITY_LOWERCASE}.dto.${ENTITY}SaveRequest;
import ${PACKAGE}.${ENTITY_LOWERCASE}.entity.${ENTITY};

import io.github.paulmarcelinbejan.coordinator.architecture.mapper.input.MapperInput;

@Mapper(config = HyperBankMapperConfig.class,
		uses = SaveOne${ENTITY}Mapper.class)
public interface SaveMany${ENTITY}Mapper extends  
	MapperInput<List<${ENTITY}SaveRequest>, List<${ENTITY}>> {
	
	@Override
	@IterableMapping(qualifiedByName = "fromSaveRequestToDomain")
	List<${ENTITY}> toDomain(List<${ENTITY}SaveRequest> request);
	
}