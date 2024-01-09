package ${PACKAGE}.${ENTITY_LOWERCASE}.api.update.one;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ${PACKAGE}.${ENTITY_LOWERCASE}.entity.${ENTITY};
import ${PACKAGE}.${ENTITY_LOWERCASE}.repository.${ENTITY}Repository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UpdateOne${ENTITY}ServiceImpl implements UpdateOne${ENTITY}Service {

	private final ${ENTITY}Repository repository; 

	@Override
	@Transactional
	public ${ENTITY} execute(${ENTITY} ${ENTITY_LOWERCASE}) {
		
		return repository.save(${ENTITY_LOWERCASE});
		
	}
	
}
