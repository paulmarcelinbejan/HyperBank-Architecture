package ${PACKAGE}.${ENTITY_LOWERCASE}.api.find.one;

import java.text.MessageFormat;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ${PACKAGE}.${ENTITY_LOWERCASE}.entity.${ENTITY};
import ${PACKAGE}.${ENTITY_LOWERCASE}.repository.${ENTITY}Repository;

import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.service.helper.utils.ServiceHelperUtils;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindOne${ENTITY}ServiceImpl implements FindOne${ENTITY}Service {

	private final ${ENTITY}Repository repository;

	@Override
	@Transactional(readOnly = true)
	public ${ENTITY} execute(${ID_TYPE} id) throws FunctionalException {
		
		return repository.findById(id)
				.orElseThrow(() -> new FunctionalException(MessageFormat.format(ServiceHelperUtils.buildErrorMessageIfEntityNotFoundById(${ENTITY}.class), id)));
	
	}
	
}
