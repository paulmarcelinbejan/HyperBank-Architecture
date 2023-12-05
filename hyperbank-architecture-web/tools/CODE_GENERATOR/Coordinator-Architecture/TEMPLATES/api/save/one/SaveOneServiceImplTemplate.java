package ${PACKAGE}.${ENTITY_LOWERCASE}.api.save.one;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ${PACKAGE}.${ENTITY_LOWERCASE}.entity.${ENTITY};
import ${PACKAGE}.${ENTITY_LOWERCASE}.repository.${ENTITY}Repository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SaveOne${ENTITY}ServiceImpl implements SaveOne${ENTITY}Service {

	private final ${ENTITY}Repository repository;

	@Override
	@Transactional
	public ${ENTITY} execute(${ENTITY} entity) {
		
		return repository.save(entity);
		
	}
	
}
