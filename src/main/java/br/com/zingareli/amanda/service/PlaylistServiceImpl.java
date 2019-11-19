package br.com.zingareli.amanda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zingareli.amanda.document.Playlist;
import br.com.zingareli.amanda.repository.IPlaylistRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PlaylistServiceImpl implements GenericService<Playlist, String> {

	@Autowired
	private IPlaylistRepository repository;

	@Override
	public Flux<Playlist> findAll() {
		return repository.findAll();
	}

	@Override
	public Mono<Playlist> findById(String id) {
		return repository.findById(id);
	}

	@Override
	public Mono<Playlist> save(Playlist o) {
		return repository.save(o);
	}
	

	
}
