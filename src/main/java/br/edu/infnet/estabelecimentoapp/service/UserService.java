package br.edu.infnet.estabelecimentoapp.service;


import br.edu.infnet.estabelecimentoapp.model.User;
import br.edu.infnet.estabelecimentoapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public void incluir(User usuario) {
		usuario.setSenha(bCryptPasswordEncoder.encode(usuario.getSenha()));
		userRepository.save(usuario);
	}
	
	public void excluir(User usuario) {
		userRepository.deleteById(usuario.getId());
	}
	
	public User autenticar(String email, String senha) {
		
		User usuarioRetornado = userRepository.findByEmail(email);
		
		if(usuarioRetornado != null && usuarioRetornado.getSenha().equals(senha)){
			return usuarioRetornado;
		}
		
		return null;
	}
}
