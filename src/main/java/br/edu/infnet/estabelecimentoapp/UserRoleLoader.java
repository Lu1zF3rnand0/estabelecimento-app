package br.edu.infnet.estabelecimentoapp;

import br.edu.infnet.estabelecimentoapp.model.Role;
import br.edu.infnet.estabelecimentoapp.model.User;
import br.edu.infnet.estabelecimentoapp.service.RoleService;
import br.edu.infnet.estabelecimentoapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class UserRoleLoader implements ApplicationRunner{

	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserService userService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		roleService.incluir(new Role("ROLE_ADMIN"));
		roleService.incluir(new Role("ROLE_USER"));

		
		User usuario1 = new User();
		usuario1.setEmail("usuario1@gmail.com");
		usuario1.setNome("Usuario1");
		usuario1.setRoles(Arrays.asList(new Role(1)));
		usuario1.setSenha("123");

		userService.incluir(usuario1);


		User usuario2 = new User();
		usuario2.setEmail("usuario2@gmail.com");
		usuario2.setNome("Usuario2");
		usuario2.setRoles(Arrays.asList(new Role(2)));
		usuario2.setSenha("123");

		userService.incluir(usuario2);
		
	}

}
