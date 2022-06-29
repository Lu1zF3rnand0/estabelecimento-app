package br.edu.infnet.estabelecimentoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EstabelecimentoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstabelecimentoAppApplication.class, args);
	}

}
