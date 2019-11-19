package br.com.zingareli.amanda.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
@Data
@Document
@AllArgsConstructor
public class Playlist extends GenericDocument{
	
	@Id
	private String id;
	private String nome;
}
