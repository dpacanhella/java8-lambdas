package br.com.dpacanhella.lambdas.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dpacanhella.lambdas.Cursos.Curso;

@RestController
@RequestMapping("/strem")
public class StreamController {

    @GetMapping
    public List<Curso> listCurso() {
        List<Curso> cursos = new ArrayList<Curso>();
        cursos.add(new Curso("Java 8", 100));
        cursos.add(new Curso("Python", 45));
        cursos.add(new Curso("JavaScript", 120));
        cursos.add(new Curso("Lambda", 30));
        cursos.add(new Curso("C/C++", 150));
        
        cursos.sort(Comparator.comparing(Curso::getQtdeAlunos));
        
        System.out.println("strem --- ");
        cursos.stream().filter(c -> c.getQtdeAlunos() >= 100).forEach(c -> System.out.println(c.getQtdeAlunos()));
        System.out.println("------");
        System.out.println("printando com sort --- ");
        cursos.forEach(c -> System.out.println(c.getNome()));
        System.out.println("------");
        
        System.out.println("strem with map --- ");
        cursos.stream().filter(c -> c.getQtdeAlunos() >= 100).map(c -> c.getQtdeAlunos()).forEach(total -> System.out.println(total));
        System.out.println("------");
        
        System.out.println("strem with map to int sum --- ");
        int sum = cursos.stream().filter(c -> c.getQtdeAlunos() >= 100).mapToInt(Curso::getQtdeAlunos).sum();
        System.out.println(sum);
        System.out.println("------");
        
        System.out.println("strem Curso convert in String --- ");
        Stream<String> map = cursos.stream().map(Curso::getNome);
        System.out.println("------");
        
        System.out.println("strem Curso convert in Integer using method reference --- ");
        cursos.stream().filter(c -> c.getQtdeAlunos() >= 100).mapToInt(Curso::getQtdeAlunos).forEach(System.out::println);
        System.out.println("------");
        
        return cursos;
    }
}
