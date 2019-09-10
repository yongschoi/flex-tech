package yongs.temp.dao;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Flux;
import yongs.temp.model.Tech;

public interface TechRepository extends ReactiveMongoRepository<Tech, Integer> {
	@Query("{ 'name': ?0 }")
    Flux<Tech> findByName(final String name);
}
