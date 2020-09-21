package at.savovuksan.VSMServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import at.savovuksan.VSMServer.Repositories.UserRepository;

@SpringBootApplication
@RestController
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class VSMServer {

	public static void main(String[] args) {
		SpringApplication.run(VSMServer.class, args);
	}

}
