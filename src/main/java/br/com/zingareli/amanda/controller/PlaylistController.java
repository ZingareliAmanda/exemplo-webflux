package br.com.zingareli.amanda.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.zingareli.amanda.document.Playlist;
import br.com.zingareli.amanda.service.PlaylistServiceImpl;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//@RestController
public class PlaylistController {
	
	@Autowired
	private PlaylistServiceImpl service;
	
	@GetMapping("/playlist")
	public Flux<Playlist> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/playlist/{id}")
	public Mono<Playlist> getPlaylistById(@PathVariable String id){
		return service.findById(id);
	}
	
	@PostMapping("/playlist")
	public Mono<Playlist> getsave(@RequestBody Playlist playlist){
		return service.save(playlist);
	}
	
	@GetMapping(value="/playlist/mvc")
	public List<String> getPlaylistByMvc() throws InterruptedException {

		System.out.println("---Start get Playlists by MVC--- " + LocalDateTime.now());


		List<String> playlistList = new ArrayList<>();
		playlistList.add("Java 8");
		playlistList.add("Spring Security");
		playlistList.add("Github");
		playlistList.add("Deploy de uma aplicação java no IBM Cloud");
		playlistList.add("Bean no Spring Framework");
		TimeUnit.SECONDS.sleep(15);

		return playlistList;

	}
}
