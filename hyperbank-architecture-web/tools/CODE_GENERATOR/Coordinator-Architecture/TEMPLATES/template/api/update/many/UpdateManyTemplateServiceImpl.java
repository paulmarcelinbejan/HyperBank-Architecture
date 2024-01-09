package ${PACKAGE}.${ENTITY_LOWERCASE}.api.update.many;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ${PACKAGE}.${ENTITY_LOWERCASE}.entity.${ENTITY};
import ${PACKAGE}.${ENTITY_LOWERCASE}.repository.${ENTITY}Repository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UpdateMany${ENTITY}ServiceImpl implements UpdateMany${ENTITY}Service {

	private final ${ENTITY}Repository repository; 

	@Override
	@Transactional
	public List<${ENTITY}> execute(List<${ENTITY}> entities) {
		
		return repository.saveAll(entities);
		
	}
	
}
