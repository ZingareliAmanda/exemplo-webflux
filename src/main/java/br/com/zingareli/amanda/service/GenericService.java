package br.com.zingareli.amanda.service;

import br.com.zingareli.amanda.document.GenericDocument;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GenericService<O extends GenericDocument,S> {
	Flux<O> findAll();
	Mono<O> findById(S id);
	Mono<O> save(O o);
}
