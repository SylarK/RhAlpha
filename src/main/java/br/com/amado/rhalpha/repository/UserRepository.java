package br.com.amado.rhalpha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.amado.rhalpha.model.RegistroPonto;
import br.com.amado.rhalpha.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
