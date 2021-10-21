package br.com.amado.rhalpha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.amado.rhalpha.model.RegistroPonto;

@Repository
public interface RegistroPontoRepository extends JpaRepository<RegistroPonto, Long> {

}
