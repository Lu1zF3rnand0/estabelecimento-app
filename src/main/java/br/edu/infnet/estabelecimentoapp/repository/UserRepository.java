package br.edu.infnet.estabelecimentoapp.repository;

import br.edu.infnet.estabelecimentoapp.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    @Query("from User u where u.email = :email and u.senha = :senha")
    User autenticar(String email, String senha);

    User findByEmail(String email);
}
