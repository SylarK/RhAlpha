package br.com.amado.rhalpha.repository;

import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.amado.rhalpha.model.RegistroPonto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public interface RegistroPontoRepository extends JpaRepository<RegistroPonto, Long> {

    @Query(value="SELECT * " +
            " FROM registro_ponto rp " +
            " WHERE rp.user_username = :username " +
            " AND rp.data_registro = :data ", nativeQuery = true)
    ArrayList<RegistroPonto> findAllPontosBySpecificDay(@Param("username") String username, @Param("data") Date data);



}
