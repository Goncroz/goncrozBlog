package br.com.generation.blogpessoal.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import br.com.generation.blogpessoal.model.Usuario;
import br.com.generation.blogpessoal.repository.UsuarioRepository;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioControllerTest {

    
    @Autowired
	private UsuarioRepository usuarioRepository;
	
	@BeforeAll
	public void start() throws ParseException {
	   
	
		
		Usuario usuario = new Usuario (0L, "Simone Oliveira", "monny@email.com.br", "13465678");
		if(usuarioRepository.findByUsuario(usuario.getUsuario()) != null)
			usuarioRepository.save(usuario);
		
		usuario = new Usuario (0L, "Elisabeth de Oliveira", "betholiveira@email.com.br", "13465278");
		if(usuarioRepository.findByUsuario(usuario.getUsuario()) != null)
			usuarioRepository.save(usuario);
		
		usuario = new Usuario (0L, "Regina de Oliveira Silva", "reginaos@email.com.br", "13465278");
		if(usuarioRepository.findByUsuario(usuario.getUsuario()) != null)
			usuarioRepository.save(usuario);

        usuario = new Usuario (0L, "João Pereira", "pereirapaulo@email.com.br", "13465278");
        if(usuarioRepository.findByUsuario(usuario.getUsuario()) != null)
            usuarioRepository.save(usuario);
	}
	
	@Test
	@DisplayName("💾 Retorna o nome")
	public void findFirstByNomeRetornaNome() throws Exception {

		Usuario usuario = usuarioRepository.findByNome("Simone Oliveira");
		assertTrue(usuario.getNome().equals("Simone Oliveira"));
	}
	
	
	@Test
	@DisplayName("💾 Retorna 3 usuarios")
	public void findAllByNomeContainingIgnoreCaseRetornaTresUsuarios() {

		List<Usuario> listaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("Oliveira");
		assertEquals(3, listaDeUsuarios.size());
	}
	
	@AfterAll
	public void end() {
		
		usuarioRepository.deleteAll();
		
	}
}

