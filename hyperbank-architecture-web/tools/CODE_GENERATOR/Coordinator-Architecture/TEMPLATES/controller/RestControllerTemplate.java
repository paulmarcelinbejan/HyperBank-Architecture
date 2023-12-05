package ${PACKAGE}.${ENTITY_LOWERCASE}.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ${PACKAGE}.${ENTITY_LOWERCASE}.api.delete.many.DeleteMany${ENTITY}Coordinator;
import ${PACKAGE}.${ENTITY_LOWERCASE}.api.delete.one.DeleteOne${ENTITY}Coordinator;
import ${PACKAGE}.${ENTITY_LOWERCASE}.api.find.all.FindAll${ENTITY}Coordinator;
import ${PACKAGE}.${ENTITY_LOWERCASE}.api.find.many.FindMany${ENTITY}Coordinator;
import ${PACKAGE}.${ENTITY_LOWERCASE}.api.find.one.FindOne${ENTITY}Coordinator;
import ${PACKAGE}.${ENTITY_LOWERCASE}.api.save.many.SaveMany${ENTITY}Coordinator;
import ${PACKAGE}.${ENTITY_LOWERCASE}.api.save.one.SaveOne${ENTITY}Coordinator;
import ${PACKAGE}.${ENTITY_LOWERCASE}.api.update.many.UpdateMany${ENTITY}Coordinator;
import ${PACKAGE}.${ENTITY_LOWERCASE}.api.update.one.UpdateOne${ENTITY}Coordinator;
import ${PACKAGE}.${ENTITY_LOWERCASE}.dto.${ENTITY}Response;
import ${PACKAGE}.${ENTITY_LOWERCASE}.dto.${ENTITY}SaveRequest;
import ${PACKAGE}.${ENTITY_LOWERCASE}.dto.${ENTITY}UpdateRequest;

import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import io.github.paulmarcelinbejan.toolbox.web.response.OkResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/${ENTITY_LOWERCASE}")
public class ${ENTITY}RestController {

	private final SaveOne${ENTITY}Coordinator saveOne${ENTITY}Coordinator;
	
	private final SaveMany${ENTITY}Coordinator saveMany${ENTITY}Coordinator;
	
	private final FindOne${ENTITY}Coordinator findOne${ENTITY}Coordinator;
	
	private final FindMany${ENTITY}Coordinator findMany${ENTITY}Coordinator;
	
	private final FindAll${ENTITY}Coordinator findAll${ENTITY}Coordinator;
	
	private final UpdateOne${ENTITY}Coordinator updateOne${ENTITY}Coordinator;
	
	private final UpdateMany${ENTITY}Coordinator updateMany${ENTITY}Coordinator;
	
	private final DeleteOne${ENTITY}Coordinator deleteOne${ENTITY}Coordinator;
	
	private final DeleteMany${ENTITY}Coordinator deleteMany${ENTITY}Coordinator;
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ${ENTITY}Response findById(@PathVariable ${ID_TYPE} id) throws FunctionalException, TechnicalException {
		return findOne${ENTITY}Coordinator.process(id);
	}
	
	@GetMapping(value = "/find-many", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<${ENTITY}Response> findMany(@RequestParam("id") List<${ID_TYPE}> ids) throws FunctionalException, TechnicalException {
		return findMany${ENTITY}Coordinator.process(ids);
	}
	
	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<${ENTITY}Response> findAll() throws FunctionalException, TechnicalException {
		return findAll${ENTITY}Coordinator.process();
	}
	
	@PostMapping(value = "/save-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ${ENTITY}Response save(@RequestBody final ${ENTITY}SaveRequest saveRequest) throws FunctionalException, TechnicalException {
		return saveOne${ENTITY}Coordinator.process(saveRequest);
	}
	
	@PostMapping(value = "/save-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<${ENTITY}Response> save(@RequestBody final List<${ENTITY}SaveRequest> saveRequests) throws FunctionalException, TechnicalException {
		return saveMany${ENTITY}Coordinator.process(saveRequests);
	}
	
	@PutMapping(value = "/update-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ${ENTITY}Response update(@RequestBody final ${ENTITY}UpdateRequest updateRequest) throws FunctionalException, TechnicalException {
		return updateOne${ENTITY}Coordinator.process(updateRequest);
	}
	
	@PutMapping(value = "/update-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<${ENTITY}Response> update(@RequestBody final List<${ENTITY}UpdateRequest> updateRequests) throws FunctionalException, TechnicalException {
		return updateMany${ENTITY}Coordinator.process(updateRequests);
	}
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@PathVariable ${ID_TYPE} id) throws FunctionalException, TechnicalException {
		deleteOne${ENTITY}Coordinator.process(id);
		return new OkResponse();
	}
	
	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@RequestParam("id") List<${ID_TYPE}> ids) throws FunctionalException, TechnicalException {
		deleteMany${ENTITY}Coordinator.process(ids);
		return new OkResponse();
	}

}
