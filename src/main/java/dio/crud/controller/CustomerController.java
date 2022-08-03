package dio.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dio.crud.model.Customer;
import dio.crud.service.CustomerService;
import dio.crud.error.service.CustomExceptionService;

/**
 * A Facade that integrates all HTTP methods used to make requests from this
 * REST API and its endpoints.
 *
 * @author devsent
 */

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomExceptionService customExceptionService;

    // Get all users.
    @GetMapping
    public ResponseEntity<Iterable<Customer>> findAll() {
        return ResponseEntity.ok(customerService.findAll());
    }

    // Get specific user by ID.
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(customerService.findById(id));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(customExceptionService.error(404,"User ID Not Found"));
        }
    }

    // Create a new user.
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Customer customer) {
        try {
            customerService.create(customer);
            return ResponseEntity.status(HttpStatus.CREATED).body(customer);
        } catch (Exception e) {
            if (customer.getEmail() == null || customer.getName() == null) {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(customExceptionService.error(400,"Bad Request"));
            }

            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(customExceptionService.error(409,
                    "User with e-mail '" + customer.getEmail() + "' already exists!"
            ));
        }
    }

    // Update specific user by ID.
    @PutMapping("/{id}")
    public ResponseEntity<Customer> update(@PathVariable Long id, @RequestBody Customer customer){
            customerService.update(id, customer);
            return ResponseEntity.ok(customer);
    }

    // Delete specific user by ID.
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            customerService.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(customExceptionService.error(404,"User ID Not Found"));
        }
    }
}
