package br.com.dpacanhella.lambdas.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api-date")
public class ApiDateController {
    
    @GetMapping()
    public void teste() {
        LocalDate today = LocalDate.now();
        System.out.println(today + "\n");
        
        LocalDate olimpiadaRio = LocalDate.of(2016, Month.JUNE, 5);
        
        int ano = olimpiadaRio.getYear() - today.getYear();
        
        System.out.println(ano + " anos faltando \n");
        
        Period periodo = Period.between(today, olimpiadaRio);
        System.out.println(periodo.getDays() + " dias faltando \n");
        
        LocalDate proximasOlimpiadas = olimpiadaRio.plusYears(4);
        System.out.println(proximasOlimpiadas + " próximas olimpíadas \n");
        
        DateTimeFormatter formatadorDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(formatadorDate.format(proximasOlimpiadas) + " valor formatado \n");
        
        DateTimeFormatter formatadorHoras = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
        LocalDateTime dataComHora = LocalDateTime.now();
        System.out.println(formatadorHoras.format(dataComHora) + " Data com Horas (LocalDateTIme) \n");
        
        
       
    }

}
