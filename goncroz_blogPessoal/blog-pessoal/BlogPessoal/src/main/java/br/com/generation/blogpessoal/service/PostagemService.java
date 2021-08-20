package br.com.generation.blogpessoal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.generation.blogpessoal.model.Postagem;
import br.com.generation.blogpessoal.repository.PostagemRepository;

@Service
public class PostagemService {

	@Autowired
	private PostagemRepository postagemRepository;

	private Postagem buscarPostagemPeloId(Long id) {

		Postagem postagemSalva = postagemRepository.findById(id).orElse(null);

		if (postagemSalva == null) {

			throw new EmptyResultDataAccessException(1);
		}

		return postagemSalva;
	}
}
