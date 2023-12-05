package ${PACKAGE}.${ENTITY_LOWERCASE}.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import com.hyperbank.architecture.web.mapper.config.HyperBankMapperConfig;
import ${PACKAGE}.${ENTITY_LOWERCASE}.dto.${ENTITY}Response;
import ${PACKAGE}.${ENTITY_LOWERCASE}.entity.${ENTITY};

import io.github.paulmarcelinbejan.coordinator.architecture.mapper.output.MapperOutput;

@Mapper(config = HyperBankMapperConfig.class)
public interface EntityToDto${ENTITY}Mapper extends 
	MapperOutput<${ENTITY}, ${ENTITY}Response> {
	
	@Override
	@Named("fromEntityToDto")
	${ENTITY}Response toResponse(${ENTITY} entity);
	
}