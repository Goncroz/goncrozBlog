package br.com.generation.blogpessoal.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import br.com.generation.blogpessoal.model.Usuario;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {


		@Autowired
		private UsuarioRepository usuarioRepository;

		@BeforeAll
		public void start() {
			
		
			
			Usuario usuario = new Usuario(0L, "Paulo Gustavo", "paulog@email.com.br", "12345");
			if (usuarioRepository.findByNome(usuario.getNome()) == null)
				usuarioRepository.save(usuario);

			usuario = new Usuario(0L, "Paulo Tanabe", "tanabepaulo@email.com.br", "12345");
			if (usuarioRepository.findByNome(usuario.getNome()) == null)
				usuarioRepository.save(usuario);

			usuario = new Usuario(0L, "Paulo Rodrigues", "rdgspaulo@email.com.br", "12345");
			if (usuarioRepository.findByNome(usuario.getNome()) == null)
				usuarioRepository.save(usuario);

			usuario = new Usuario(0L, "Janaina Silva", "janaina@email.com.br", "12345");
			if (usuarioRepository.findByNome(usuario.getNome()) == null)
				usuarioRepository.save(usuario);
		}

		@Test
		public void findByNomeRetornaContato() throws Exception {

			Usuario usuario = usuarioRepository.findByNome("Paulo Gustavo"); //nome completo

			assertTrue(usuario.getNome().equals("Paulo Gustavo"));
		}

		@Test
		public void findAllByNomeIgnoreCaseRetornaTresContato() {

			List<Usuario> usuario = usuarioRepository.findAllByNomeContainingIgnoreCase("Paulo");

			assertEquals(3, usuario.size());
		}
	
		@AfterAll
		public void end() {
			usuarioRepository.deleteAll();
		}
}
