package com.maruan.crudspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.maruan.crudspring.controller.model.Conteiner;
import com.maruan.crudspring.repository.ConteinerRepository;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner initDataBase(ConteinerRepository conteinerRepository){
		return args -> {
			conteinerRepository.deleteAll();
			Conteiner c = new Conteiner();
			c.setClient("MM Exportaçoes");
			c.setNumberOfConteiner("ffde9384092");
			c.setType("40");
			c.setStatus("Vazio");
			c.setCategory("Exportação");
			conteinerRepository.save(new Conteiner());
		};
	}

}
