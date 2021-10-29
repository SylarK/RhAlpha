package br.com.amado.rhalpha.api;

import br.com.amado.rhalpha.dto.RegistrosPontoDTO;
import br.com.amado.rhalpha.dto.NovoRegistroPontoDTO;
import br.com.amado.rhalpha.model.RegistroPonto;
import br.com.amado.rhalpha.model.User;
import br.com.amado.rhalpha.repository.RegistroPontoRepository;
import br.com.amado.rhalpha.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.ArrayList;
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

		String tipo = registroPontoRepository.findPositionToFindTheType(dateValue) % 2 == 0 ? "Entrada" : "Saída";

		registro.toRecord(timeValue, dateValue, usuario, tipo);
		registroPontoRepository.save(registro);

		return registro.toString();
	}

	@GetMapping("getRegistros")
	public List<RegistrosPontoDTO> retornarPontosRegistrados(){

		User user = new User();

		String username = user.getUsernameFromUser();
		LocalDate dateNow = LocalDate.now();
		Date dateValue = java.util.Date.from(dateNow.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());

		List<RegistroPonto> temporario = new ArrayList<>(registroPontoRepository.findAllPontosBySpecificDay(username, dateValue));

		List<RegistrosPontoDTO> lista = RegistrosPontoDTO.converter(temporario);

		if(lista.size() > 6){
			lista.remove(lista.size());
		}

		return lista;
	}
	
}
