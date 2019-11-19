package br.com.zingareli.amanda.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Component;

import br.com.zingareli.amanda.document.Playlist;

@Component
public interface IPlaylistRepository extends ReactiveMongoRepository<Playlist, String>{

}
