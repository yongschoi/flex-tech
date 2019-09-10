package yongs.temp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import yongs.temp.model.Tech;
import yongs.temp.service.TechService;

@RestController
public class TechController {
	private Logger logger = LoggerFactory.getLogger(TechController.class);
	@Autowired
    private TechService service;
	
    @PostMapping("/tech/create") /* Postman 프로그램으로 실행 */
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Tech e) {
    	logger.debug("flex-tech|TechController|create()");
        service.create(e);
    }
    
    @GetMapping("/tech/id/{id}")
    public ResponseEntity<Mono<Tech>> findById(@PathVariable("id") Integer id) {
    	logger.debug("flex-tech|TechController|findById({})", id);
    	Mono<Tech> e = service.findById(id);
        HttpStatus status = e != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<Mono<Tech>>(e, status);
    }
 
    @GetMapping("/tech/name/{name}")
    public Flux<Tech> findByName(@PathVariable("name") String name) {
    	logger.debug("flex-tech|TechController|findByName({})", name);
        return service.findByName(name);
    }
 
    @GetMapping("/techs")
    public Flux<Tech> findAll() {
    	logger.debug("flex-tech|TechController|findAll()");    	
        Flux<Tech> emps = service.findAll();
        return emps;
    }
 
    @PutMapping("/tech/update")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Tech> update(@RequestBody Tech e) {
    	logger.debug("flex-tech|TechController|update()");    	    	
        return service.update(e);
    }
 
    @DeleteMapping("/tech/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Void> delete(@PathVariable("id") Integer id) {
    	logger.debug("flex-tech|TechController|delete({})", id);      	
        return service.delete(id);
    }
}
