package ${PACKAGE}.${ENTITY_LOWERCASE}.api.find.all;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ${PACKAGE}.${ENTITY_LOWERCASE}.entity.${ENTITY};
import ${PACKAGE}.${ENTITY_LOWERCASE}.repository.${ENTITY}Repository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindAll${ENTITY}ServiceImpl implements FindAll${ENTITY}Service {

	private final ${ENTITY}Repository repository;

	@Override
	@Transactional(readOnly = true)
	public List<${ENTITY}> execute() {
		
		return repository.findAll();
		
	}
	
}
