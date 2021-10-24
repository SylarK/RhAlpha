package br.com.amado.rhalpha.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {

	@Id
	private String username;
	private String password;
	private Boolean enabled;

	public String getUsernameFromUser(){
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;

		if(principal instanceof UserDetails) {
			username = ((UserDetails)principal).getUsername();
		}else {
			username = principal.toString();
		}

		return  username;
	}
}
