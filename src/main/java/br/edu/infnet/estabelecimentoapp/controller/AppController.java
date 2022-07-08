package br.edu.infnet.estabelecimentoapp.controller;

import br.edu.infnet.estabelecimentoapp.model.Usuario;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

@SessionAttributes("user")
@Controller
public class AppController {

    @GetMapping("/")
    public String index() {
        return "index";
    }


    @GetMapping(value = "/login")
    public String telaLogin() {
        return "login";
    }

    @GetMapping(value = "/negado")
    public String telaNegado() {
        return "negado";
    }

    @PostMapping(value = "/login")
    public String login(@AuthenticationPrincipal Usuario usuario, Model model) {
        return "redirect:/";
    }

    @GetMapping(value = "/logout")
    public String logout(HttpSession session, SessionStatus status) {
        status.setComplete();
        session.removeAttribute("user");
        return "redirect:/";
    }
}
