package ${PACKAGE}.${ENTITY_LOWERCASE}.api.delete.one;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ${PACKAGE}.${ENTITY_LOWERCASE}.repository.${ENTITY}Repository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeleteOne${ENTITY}ServiceImpl implements DeleteOne${ENTITY}Service {

	private final ${ENTITY}Repository repository;

	@Override
	@Transactional
	public void execute(${ID_TYPE} id) {
		
		repository.deleteById(id);
	
	}
	
}
