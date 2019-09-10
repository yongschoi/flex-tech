package yongs.temp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import yongs.temp.dao.TechRepository;
import yongs.temp.model.Tech;

@Service
public class TechService implements ITech {
	private Logger logger = LoggerFactory.getLogger(TechService.class);	

	@Autowired
    TechRepository repo;
	
	@Override
	public void create(Tech e) {
		logger.debug("flex-tech|TechService|create()");
		repo.save(e).subscribe();
	}

	@Override
	public Mono<Tech> findById(Integer id) {
		logger.debug("flex-tech|TechService|findById({})", id);
		return repo.findById(id);
	}

	@Override
	public Flux<Tech> findByName(String name) {
		logger.debug("flex-tech|TechService|findByName({})", name);
		return repo.findByName(name);
	}

	@Override
	public Flux<Tech> findAll() {
		logger.debug("flex-tech|TechService|findAll()");
		try {
			Thread.sleep(30000); // 5초 대기
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		return repo.findAll();
	}

	@Override
	public Mono<Tech> update(Tech e) {
		logger.debug("flex-tech|TechService|update()");
		return repo.save(e);
	}

	@Override
	public Mono<Void> delete(Integer id) {
		logger.debug("flex-tech|TechService|delete({})", id);
		return repo.deleteById(id);
	}
}
