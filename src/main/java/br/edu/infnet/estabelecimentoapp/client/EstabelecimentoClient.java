package br.edu.infnet.estabelecimentoapp.client;

import br.edu.infnet.estabelecimentoapp.model.Estabelecimento;
import br.edu.infnet.estabelecimentoapp.model.Funcionario;
import br.edu.infnet.estabelecimentoapp.model.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(url = "localhost:8081/api", name = "estabelecimentoClient")
public interface EstabelecimentoClient {

    @GetMapping("/usuario/listar")
    List<Usuario> obterLista();

    @DeleteMapping("usuario/{id}/excluir")
    void excluir(@PathVariable Integer id);

    @PostMapping("usuario/validar")
    Usuario validar(@RequestParam String login, @RequestParam String senha);

    @PostMapping("funcionario/incluir")
    void incluirFuncionario(@RequestBody Funcionario funcionario);

    @GetMapping("funcionario/{idEstabelecimento}/listar")
    List<Funcionario> funcionariosPorEstabelecimento(@PathVariable Integer idEstabelecimento);

    @PostMapping("estabelecimento/incluir")
    void incluirEstabelecimento(@RequestBody Estabelecimento estabelecimento);

    @GetMapping("estabelecimento/listar")
    List<Estabelecimento> listarEstabelecimento();

}
