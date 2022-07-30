package dio.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * A CRUD REST API created using Spring Initializr.
 * Dependencies added:
 * - Spring Data JPA
 * - Spring Web
 * - H2 Database
 *
 * @author devsent
 */

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
