package br.com.generation.blogpessoal.seguranca;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import br.com.generation.blogpessoal.model.Usuario;
import br.com.generation.blogpessoal.repository.UsuarioRepository;

@Service //classe de serviço
public class UserDetailsServiceImpl implements UserDetailsService  {

		@Autowired
		private UsuarioRepository userRepository;

		@Override
		public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

			Optional<Usuario> usuario = userRepository.findByUsuario(userName);
			usuario.orElseThrow(() -> new UsernameNotFoundException(userName + " not found."));

			return usuario.map(UserDetailsImpl::new).get();
		}
}
