package br.com.amado.rhalpha.controller;

import br.com.amado.rhalpha.model.RegistroPonto;
import br.com.amado.rhalpha.model.User;
import br.com.amado.rhalpha.repository.RegistroPontoRepository;
import br.com.amado.rhalpha.services.GeneratePdfReport;
import br.com.amado.rhalpha.services.GetTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.ByteArrayInputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
public class ReportController {

    @Autowired
    RegistroPontoRepository registroPontoRepository;

    User user = new User();

    @RequestMapping("/report")
    public String reportHome() { return "report"; }

//    @RequestMapping(value = "/report/pdfreport", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
//    public String pdfReport(){
//
//        new GetTime().recuperarUltimaSemana();
//        new GetTime().recuperarSemanaAtual();
//
//        return "report";
//    }

    @RequestMapping(value = "/report/pdf/currentWeek", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> reportCurrentWeek(){

        String username = user.getUsernameFromUser();
        List<Date> dados = new GetTime().recuperarSemanaAtual();

        var records = (List<RegistroPonto>) registroPontoRepository.findAllByPeriod(username, dados.get(0), dados.get(1));

        ByteArrayInputStream bis = GeneratePdfReport.relatorioSemanalRegistrosPonto(records);

        var headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=registrosreport.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

    @RequestMapping(value = "/report/pdf/lastWeek", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> reportLastWeek(){

        String username = user.getUsernameFromUser();
        List<Date> dados = new GetTime().recuperarUltimaSemana();

        var records = (List<RegistroPonto>) registroPontoRepository.findAllByPeriod(username, dados.get(0), dados.get(1));

        System.out.println(dados.get(0));
        System.out.println(dados.get(1));

        ByteArrayInputStream bis = GeneratePdfReport.relatorioSemanalRegistrosPonto(records);

        var headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=registrosreport.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

    @RequestMapping(value = "/report/pdf/personalFilter/{dInicial}&{dFinal}", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> reportPersonal(@PathVariable String dInicial, @PathVariable String dFinal) throws ParseException{

        String username = user.getUsernameFromUser();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        Date dataInicial = formatter.parse(dInicial);
        Date dataFinal = formatter.parse(dFinal);

        var records = (List<RegistroPonto>) registroPontoRepository.findAllByPeriod(username, dataInicial, dataFinal);

        ByteArrayInputStream bis = GeneratePdfReport.relatorioSemanalRegistrosPonto(records);

        var headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=registrosreport.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));

    }

}
