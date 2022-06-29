package br.edu.infnet.estabelecimentoapp.controller;

import br.edu.infnet.estabelecimentoapp.model.Estabelecimento;
import br.edu.infnet.estabelecimentoapp.service.EstabelecimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class EstabelecimentoController {

    @Autowired
    EstabelecimentoService estabelecimentoService;

    @GetMapping(value = "/estabelecimentos")
    public String telaListaEstabelecimentos(Model model){
        model.addAttribute("lista", estabelecimentoService.listarEstabelecimentos());
        return "estabelecimentos";
    }

    @GetMapping(value = "/funcionarios/{id}")
    public String telaListFuncionarios(Model model, @PathVariable Integer id){
        Optional<Estabelecimento> estabelecimento = estabelecimentoService.listarEstabelecimentos()
                .stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();

        model.addAttribute("lista", estabelecimentoService.listarFuncionariosPorIdEstabelecimento(id));
        estabelecimento.ifPresent(value -> model.addAttribute("estabelecimento", value.getNome()));
        return "funcionarios";
    }

    @GetMapping(value = "usuario/{id}")
    public String excluirUsuario(@PathVariable Integer id){
        estabelecimentoService.excluir(id);
        return "redirect:/estabelecimentos";
    }

}
