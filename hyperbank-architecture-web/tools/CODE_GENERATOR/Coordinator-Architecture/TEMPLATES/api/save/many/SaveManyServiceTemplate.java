package ${PACKAGE}.${ENTITY_LOWERCASE}.api.save.many;

import java.util.List;

import ${PACKAGE}.${ENTITY_LOWERCASE}.entity.${ENTITY};

import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceInputOutputAware;

public interface SaveMany${ENTITY}Service extends ServiceInputOutputAware<List<${ENTITY}>, List<${ENTITY}>> {

}
