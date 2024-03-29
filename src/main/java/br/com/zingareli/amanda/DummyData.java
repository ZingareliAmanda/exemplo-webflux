package br.com.zingareli.amanda;


import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.zingareli.amanda.document.Playlist;
import br.com.zingareli.amanda.repository.IPlaylistRepository;
import reactor.core.publisher.Flux;

@Component
public class DummyData  implements CommandLineRunner{
	
	private final IPlaylistRepository playlistRepository;
	
    DummyData(IPlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    @Override
    public void run(String... args) throws Exception {

    	playlistRepository.deleteAll()
                .thenMany(
                        Flux.just("API REST Spring Boot", "Deploy de uma aplicação java no IBM Cloud", "Java 8",
                                "Github", "Spring Security", "Web Service RESTFULL", "Bean no Spring Framework")
                                .map(nome -> new Playlist(UUID.randomUUID().toString(), nome))
                                .flatMap(playlistRepository::save))
                .subscribe(System.out::println);
    }


}
