package br.com.zingareli.amanda;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import br.com.zingareli.amanda.document.Playlist;
import br.com.zingareli.amanda.service.PlaylistServiceImpl;
import reactor.core.publisher.Mono;

@Component
public class PlaylistHandler {

	@Autowired
	private PlaylistServiceImpl service;
	
	public Mono<ServerResponse> findAll(ServerRequest request){
		return ok().contentType(MediaType.APPLICATION_JSON).body(service.findAll(), Playlist.class);
	}
	
	public Mono<ServerResponse> findById(ServerRequest request){
		String id = request.pathVariable("id");
		return ok().contentType(MediaType.APPLICATION_JSON).body(service.findById(id), Playlist.class);
	}
	
	public Mono<ServerResponse> save(ServerRequest request){
		final Mono<Playlist> playlist = request.bodyToMono(Playlist.class);
		return ok().contentType(MediaType.APPLICATION_JSON).body(fromPublisher(playlist.flatMap(service::save), Playlist.class));
	}
}
