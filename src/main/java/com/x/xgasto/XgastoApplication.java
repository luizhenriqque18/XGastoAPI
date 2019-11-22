package com.x.xgasto;

import com.x.xgasto.domain.Pessoa;
import com.x.xgasto.enums.SexoEnum;
import com.x.xgasto.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class XgastoApplication {

    @Autowired
    private PessoaRepository pessoaRepository;

    public static void main(String[]  args) {
        SpringApplication.run(XgastoApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner commandLineRunner(){
//        return args -> {
//            Pessoa pessoa  = new Pessoa();
//
//            pessoa.setNome("Luiz Henrique Oliveira de Souza");
//            pessoa.setSexo(SexoEnum.M);
//
//            //pessoaRepository.save(pessoa);
//
//            //List<Pessoa> pessoas = pessoaRepository.findAll();
//            //pessoas.forEach(System.out::println);
//        };
//    }
}
