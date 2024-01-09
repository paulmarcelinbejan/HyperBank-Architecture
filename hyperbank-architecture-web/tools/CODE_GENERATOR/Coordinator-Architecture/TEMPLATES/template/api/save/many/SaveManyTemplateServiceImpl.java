package ${PACKAGE}.${ENTITY_LOWERCASE}.api.save.many;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ${PACKAGE}.${ENTITY_LOWERCASE}.entity.${ENTITY};
import ${PACKAGE}.${ENTITY_LOWERCASE}.repository.${ENTITY}Repository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SaveMany${ENTITY}ServiceImpl implements SaveMany${ENTITY}Service {

	private final ${ENTITY}Repository repository;

	@Override
	@Transactional
	public List<${ENTITY}> execute(List<${ENTITY}> entities) {

		return repository.saveAll(entities);
		
	}
	
}
