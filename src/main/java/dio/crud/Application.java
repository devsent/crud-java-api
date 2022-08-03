package dio.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * A CRUD REST API created using Spring Initializr.
 * Dependencies added:
 * - H2 Database
 * - Spring Data JPA
 * - Spring Security
 * - Spring Web
 *
 * @author devsent
 */

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
