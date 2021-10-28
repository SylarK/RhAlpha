package br.com.amado.rhalpha.controller;

import br.com.amado.rhalpha.model.RegistroPonto;
import br.com.amado.rhalpha.repository.RegistroPontoRepository;
import br.com.amado.rhalpha.services.GeneratePdfReport;
import br.com.amado.rhalpha.services.GetTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.ByteArrayInputStream;
import java.util.List;

@Controller
public class ReportController {

    @Autowired
    RegistroPontoRepository registroPontoRepository;

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

//    @RequestMapping(value = "/report/pdfreport/week", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
//    public ResponseEntity<InputStreamResource> pdfReportWeek(){
//
//        //var records = (List<RegistroPonto>) registroPontoRepository.findAllPontosCurrentWeek();
//
//        ByteArrayInputStream bis = GeneratePdfReport.relatorioSemanalRegistrosPonto(records);
//
//        var headers = new HttpHeaders();
//        headers.add("Content-Disposition", "inline; filename=registrosreport.pdf");
//
//        return ResponseEntity
//                .ok()
//                .headers(headers)
//                .contentType(MediaType.APPLICATION_PDF)
//                .body(new InputStreamResource(bis));
//    }

}
