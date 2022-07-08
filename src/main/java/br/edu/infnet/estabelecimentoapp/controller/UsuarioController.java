package br.edu.infnet.estabelecimentoapp.controller;

import br.edu.infnet.estabelecimentoapp.model.Role;
import br.edu.infnet.estabelecimentoapp.model.User;
import br.edu.infnet.estabelecimentoapp.service.RoleService;
import br.edu.infnet.estabelecimentoapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UsuarioController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping(value="/usuario")
	public String telaCadastro(Model model) {
		User usuario = new User();
		model.addAttribute("roles", roleService.obterLista());
		model.addAttribute("usuario", usuario);

		return "usuario/cadastro";
	}
	
	@PostMapping(value="/usuario/incluir")
	public String incluir(User usuario, @RequestParam Integer acesso) {

		usuario.setRoles(List.of(new Role(acesso)));
		userService.incluir(usuario);
		
		return "redirect:/";
	}

}
