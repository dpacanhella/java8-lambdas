package br.com.dpacanhella.lambdas.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class TesteController {

    // @Autowired
    // private LambdaService lambdaService;

    @GetMapping()
    public List<String> palavras() {

        List<String> palavras = new ArrayList<String>();
        palavras.add("Diego Pacanhella");
        palavras.add("Lucas tavares");
        palavras.add("Douglas Gomes");
        palavras.add("Bruno Queiroz");

        palavras.forEach(t -> System.out.println(t));
        palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));

        
        new Thread(() -> System.out.println("Executando um Runnable")).start();

        return palavras;
    }
}
