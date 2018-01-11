package br.com.dpacanhella.lambdas.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dpacanhella.lambdas.Cursos.Curso;

@RestController
@RequestMapping("/collectors")
public class CollectorsController {

    
    @GetMapping()
    public List<Curso> collectors(){
        List<Curso> cursos = new ArrayList<Curso>();
        cursos.add(new Curso("Java 8", 100));
        cursos.add(new Curso("Python", 45));
        cursos.add(new Curso("JavaScript", 120));
        cursos.add(new Curso("Lambda", 30));
        cursos.add(new Curso("C/C++", 150));
        
        //Tratando nullPoiter retornando um optinal
        System.out.println("Retornando o nome do curso quando for maior que X -----");
        cursos.stream()
                   .filter(c -> c.getQtdeAlunos() >= 100)
                   .findAny()
                   .ifPresent(c -> System.out.println(c.getNome()));
        System.out.println("--------------");
       
        //devolvendo uma lista de cursos através de um collect
        cursos = cursos.stream()
                .filter(c -> c.getQtdeAlunos() >= 100)
                   .collect(Collectors.toList());
         
        
        //devolvendo um map
        cursos.stream()
                .filter(c -> c.getQtdeAlunos() >= 100)
                .collect(Collectors.toMap(c -> c.getNome(), c -> c.getQtdeAlunos()))
                .forEach((nome, alunos) -> System.out.print(nome + " tem " + alunos + " alunos \n"));
        
        System.out.println("--------------");
        
        OptionalDouble quantidadeMedia = cursos.stream().filter(c -> c.getQtdeAlunos() >= 100).mapToInt(Curso::getQtdeAlunos).average();
        System.out.println("Quantidade média: " + quantidadeMedia);
        
        //Transformando stream em uma lista
        List<Curso> collect = cursos.stream().filter(c -> c.getQtdeAlunos() >= 100).collect(Collectors.toList());
        
        return cursos;
    }
}
