package ${PACKAGE}.${ENTITY_LOWERCASE}.api.update.many;

import java.util.List;

import ${PACKAGE}.${ENTITY_LOWERCASE}.entity.${ENTITY};

import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceInputOutputAware;

public interface UpdateMany${ENTITY}Service extends ServiceInputOutputAware<List<${ENTITY}>, List<${ENTITY}>> {

}
