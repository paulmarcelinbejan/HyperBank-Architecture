package ${PACKAGE}.${ENTITY_LOWERCASE}.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import com.hyperbank.architecture.web.mapper.config.HyperBankMapperConfig;
import ${PACKAGE}.${ENTITY_LOWERCASE}.dto.${ENTITY}Response;
import ${PACKAGE}.${ENTITY_LOWERCASE}.entity.${ENTITY};

import io.github.paulmarcelinbejan.coordinator.architecture.mapper.output.MapperOutput;

@Mapper(config = HyperBankMapperConfig.class, 
		uses = { EntityToDto${ENTITY}Mapper.class })
public interface EntitiesToDtos${ENTITY}Mapper 
	extends MapperOutput<List<${ENTITY}>, List<${ENTITY}Response>> {

	@Override
	@IterableMapping(qualifiedByName = "fromEntityToDto")
	List<${ENTITY}Response> toResponse(List<${ENTITY}> entities);

}