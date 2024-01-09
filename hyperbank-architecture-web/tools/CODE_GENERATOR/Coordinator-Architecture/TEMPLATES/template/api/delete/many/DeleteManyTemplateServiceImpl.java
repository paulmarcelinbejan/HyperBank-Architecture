package ${PACKAGE}.${ENTITY_LOWERCASE}.api.delete.many;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ${PACKAGE}.${ENTITY_LOWERCASE}.repository.${ENTITY}Repository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeleteMany${ENTITY}ServiceImpl implements DeleteMany${ENTITY}Service {

	private final ${ENTITY}Repository repository;
	
	/**
	 * DELETE ALL BY ID
	 * <br>Entities that aren't found in the persistence store are silently ignored.
	 */
	@Override
	@Transactional
	public void execute(List<${ID_TYPE}> ids) {
		
		repository.deleteAllById(ids);
		
	}
	
}
