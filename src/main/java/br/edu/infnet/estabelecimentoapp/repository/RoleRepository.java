package br.edu.infnet.estabelecimentoapp.repository;

import br.edu.infnet.estabelecimentoapp.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer>{
	
	Role findByNome(String nome);

}
