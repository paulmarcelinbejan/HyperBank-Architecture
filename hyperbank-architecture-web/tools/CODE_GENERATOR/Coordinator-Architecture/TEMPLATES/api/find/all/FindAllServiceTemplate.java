package ${PACKAGE}.${ENTITY_LOWERCASE}.api.find.all;

import java.util.List;

import ${PACKAGE}.${ENTITY_LOWERCASE}.entity.${ENTITY};

import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceOutputAware;

public interface FindAll${ENTITY}Service extends ServiceOutputAware<List<${ENTITY}>> {

}
