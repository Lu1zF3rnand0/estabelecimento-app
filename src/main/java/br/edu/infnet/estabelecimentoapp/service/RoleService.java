package br.edu.infnet.estabelecimentoapp.service;

import br.edu.infnet.estabelecimentoapp.model.Role;
import br.edu.infnet.estabelecimentoapp.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	public void incluir(Role role) {
		roleRepository.save(role);
	}

	public List<Role> obterLista() {
		return (List<Role>) roleRepository.findAll();
	}

	public Role obterPorId(String nome) {
		return roleRepository.findByNome(nome);
	}

}
