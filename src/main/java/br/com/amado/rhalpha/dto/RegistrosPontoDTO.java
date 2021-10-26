package br.com.amado.rhalpha.dto;

import br.com.amado.rhalpha.model.RegistroPonto;
import br.com.amado.rhalpha.model.User;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class RegistrosPontoDTO {

    private Long id;
    private String user;
    private Time horaRegistro;
    private java.util.Date dataRegistro;

    public RegistrosPontoDTO(RegistroPonto registro){
        this.id = registro.getId_registro();
        this.user = registro.getUser().getUsername();
        this.horaRegistro = registro.getHoraRegistro();
        this.dataRegistro = registro.getDataRegistro();
    }

    public static List<RegistrosPontoDTO> converter(List<RegistroPonto> registros){

        List<RegistrosPontoDTO> lista = registros.stream().map(RegistrosPontoDTO::new).collect(Collectors.toList());

        return lista;
    }
}
