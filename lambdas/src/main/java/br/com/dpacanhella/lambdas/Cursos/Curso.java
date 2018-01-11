package br.com.dpacanhella.lambdas.Cursos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Curso {

    private String nome;
    private int qtdeAlunos;
}