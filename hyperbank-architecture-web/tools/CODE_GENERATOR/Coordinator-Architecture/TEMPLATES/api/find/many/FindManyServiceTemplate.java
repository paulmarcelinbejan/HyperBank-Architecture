package ${PACKAGE}.${ENTITY_LOWERCASE}.api.find.many;

import java.util.List;

import ${PACKAGE}.${ENTITY_LOWERCASE}.entity.${ENTITY};

import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceInputOutputAware;

public interface FindMany${ENTITY}Service extends ServiceInputOutputAware<List<${ID_TYPE}>, List<${ENTITY}>> {

}
