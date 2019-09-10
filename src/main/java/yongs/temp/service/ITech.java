package yongs.temp.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import yongs.temp.model.Tech;

public interface ITech {
    void create(Tech e); 
    Mono<Tech> findById(Integer id);
    Flux<Tech> findByName(String name);
    Flux<Tech> findAll();
    Mono<Tech> update(Tech e);
    Mono<Void> delete(Integer id);
}
