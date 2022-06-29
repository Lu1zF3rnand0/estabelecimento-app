package br.edu.infnet.estabelecimentoapp.controller;

import br.edu.infnet.estabelecimentoapp.service.EstabelecimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
        model.addAttribute("lista", estabelecimentoService.listarFuncionariosPorIdEstabelecimento(id));
        return "funcionarios";
    }

}
