package br.nom.wbarbosa.mvc.mudi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class AplicacaoMudiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AplicacaoMudiApplication.class, args);
	}

}
