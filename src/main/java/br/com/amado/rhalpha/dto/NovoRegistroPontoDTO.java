package br.com.amado.rhalpha.dto;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NovoRegistroPontoDTO {

	private String horaRegistro;
	private String dataRegistro;
	private String nomeUsuario;
	
	public void atribuirNomeUsuario() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		String username;
		
		if(principal instanceof UserDetails) {
			username = ((UserDetails)principal).getUsername();
		}else {
			username = principal.toString();
		}
		
		this.nomeUsuario = username;
	}
	
}
