package br.com.amado.rhalpha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.amado.rhalpha.model.RegistroPonto;
import br.com.amado.rhalpha.model.User;

import java.util.ArrayList;
import java.util.Date;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Query(value="SELECT * " +
            " FROM users u " +
            " WHERE u.id_discord = :id ", nativeQuery = true)
    User getByIdDiscord(@Param("id") Long idDiscord);

}
