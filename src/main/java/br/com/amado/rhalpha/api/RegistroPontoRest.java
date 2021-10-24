package br.com.amado.rhalpha.api;

import br.com.amado.rhalpha.dto.NovoRegistroPontoDTO;
import br.com.amado.rhalpha.model.RegistroPonto;
import br.com.amado.rhalpha.model.User;
import br.com.amado.rhalpha.repository.RegistroPontoRepository;
import br.com.amado.rhalpha.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/ponto")
public class RegistroPontoRest {

	DateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
	DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

	@Autowired
	private RegistroPontoRepository registroPontoRepository;

	@Autowired
	private UserRepository userRepository;

	@GetMapping("registrar")
	public String criaRegistroPonto() throws ParseException {

		NovoRegistroPontoDTO novoRegistro = new NovoRegistroPontoDTO();
		novoRegistro.atribuirNomeUsuario();

		LocalDate dateNow = LocalDate.now();
		LocalTime timeNow = LocalTime.now();

		Time timeValue = Time.valueOf(timeNow);
		Date dateValue = java.util.Date.from(dateNow.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());

		RegistroPonto registro = new RegistroPonto();
		User usuario = userRepository.getById(novoRegistro.getNomeUsuario());

		registro.toRecord(timeValue, dateValue, usuario);
		registroPontoRepository.save(registro);
		return registro.toString();
	}
	
}
