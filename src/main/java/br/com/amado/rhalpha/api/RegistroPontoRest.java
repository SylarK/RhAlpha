package br.com.amado.rhalpha.api;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.amado.rhalpha.dto.NovoRegistroPontoDTO;
import br.com.amado.rhalpha.model.RegistroPonto;
import br.com.amado.rhalpha.model.User;
import br.com.amado.rhalpha.repository.RegistroPontoRepository;
import br.com.amado.rhalpha.repository.UserRepository;

@RestController
@RequestMapping("api/ponto")
public class RegistroPontoRest {
	
	DateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	@Autowired
	private RegistroPontoRepository registroPontoRepository;
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("registrarteste")
	public String testeRegistro() throws ParseException {
		DateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		RegistroPonto registro = new RegistroPonto();
		User usuario = userRepository.getById("admin");
		
		Time timeValue = new Time(timeFormat.parse("19:00:00").getTime());
		Date dateValue = dateFormat.parse("20/10/2021");
		
		
		
		registro.toRecord(timeValue, dateValue, usuario);
		registroPontoRepository.save(registro);
		return registro.toString();
	}
	
	@PostMapping("registrar")
	public String criaRegistroPonto(@RequestBody NovoRegistroPontoDTO novoRegistro) throws ParseException {
		novoRegistro.atribuirNomeUsuario();
				
		RegistroPonto registro = new RegistroPonto();
		User usuario = userRepository.getById(novoRegistro.getNomeUsuario());
		
		Time timeValue = new Time(this.timeFormat.parse(novoRegistro.getHoraRegistro()).getTime());
		Date dateValue = this.dateFormat.parse(novoRegistro.getDataRegistro());
		
		registro.toRecord(timeValue, dateValue, usuario);
		registroPontoRepository.save(registro);
		return registro.toString();
	}
	
}