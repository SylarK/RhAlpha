package br.com.amado.rhalpha.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "registro_ponto")
public class RegistroPonto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_registro;
	
	@ManyToOne
	private User user;
	
	@Column(name = "hora_registro")
	private Time horaRegistro;
	
	@Column(name = "data_registro")
	private java.util.Date dataRegistro;

	@Column(name = "tipo_registro")
	private String tipoRegistro;

	public void toRecord(Time horaRegistro, java.util.Date dateValue, User usuario) {

		this.horaRegistro = horaRegistro;
		this.dataRegistro = dateValue;
		this.user = usuario;
		
	}

	public void toRecord(Time horaRegistro, java.util.Date dateValue, User usuario, String tipo) {

		this.horaRegistro = horaRegistro;
		this.dataRegistro = dateValue;
		this.user = usuario;
		this.tipoRegistro = tipo;

	}

	public RegistroPonto(){}

	
}
