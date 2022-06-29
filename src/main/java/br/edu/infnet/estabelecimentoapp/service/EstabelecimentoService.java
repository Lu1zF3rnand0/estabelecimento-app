package br.edu.infnet.estabelecimentoapp.service;

import br.edu.infnet.estabelecimentoapp.client.EstabelecimentoClient;
import br.edu.infnet.estabelecimentoapp.model.Estabelecimento;
import br.edu.infnet.estabelecimentoapp.model.Funcionario;
import br.edu.infnet.estabelecimentoapp.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstabelecimentoService {

    @Autowired
    EstabelecimentoClient estabelecimentoClient;

    public List<Usuario> listarUsuarios(){
        return estabelecimentoClient.obterLista();
    }

    public Usuario validarUsuario(String login, String senha){
        return estabelecimentoClient.validar(login, senha);
    }

    public void excluir(Integer id){
        estabelecimentoClient.excluir(id);
    }

    public void incluirFuncionario(Funcionario funcionario){
        estabelecimentoClient.incluirFuncionario(funcionario);
    }

    public void incluirEstabelecimento(Estabelecimento estabelecimento){
        estabelecimentoClient.incluirEstabelecimento(estabelecimento);
    }

    public List<Funcionario> listarFuncionariosPorIdEstabelecimento(Integer id){
        return estabelecimentoClient.funcionariosPorEstabelecimento(id);
    }

    public List<Estabelecimento> listarEstabelecimentos(){
        return estabelecimentoClient.listarEstabelecimento();
    }

}
