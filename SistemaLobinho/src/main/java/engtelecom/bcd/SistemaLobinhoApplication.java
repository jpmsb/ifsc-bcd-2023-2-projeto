package engtelecom.bcd;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SistemaLobinhoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaLobinhoApplication.class, args);
	}

	@Bean
	public CommandLineRunner principal(){
		return args -> {
			System.out.println("Iniciando....");
		};
	}
}