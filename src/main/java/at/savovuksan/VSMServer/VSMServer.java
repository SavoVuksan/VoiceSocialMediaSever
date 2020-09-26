package at.savovuksan.VSMServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class VSMServer {
	public static void main(String[] args) {
		SpringApplication.run(VSMServer.class, args);
	}

}
