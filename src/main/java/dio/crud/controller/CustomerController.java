package dio.crud.controller;

import dio.crud.model.Customer;
import dio.crud.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    // Get all users.
    @GetMapping
    public ResponseEntity<Iterable<Customer>> findAll() {
        return ResponseEntity.ok(customerService.findAll());
    }

    // Get specific user by ID.
    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.findById(id));
    }

    // Create a new user.
    @PostMapping
    public ResponseEntity<Customer> create(@RequestBody Customer customer) {
        customerService.create(customer);
        return ResponseEntity.ok(customer);
    }

    // Update specific user by ID.
    @PutMapping("/{id}")
    public ResponseEntity<Customer> update(@PathVariable Long id, @RequestBody Customer customer){
        customerService.update(id, customer);
        return ResponseEntity.ok(customer);
    }

    // Delete specific user by ID.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        customerService.delete(id);
        return ResponseEntity.ok().build();
    }
}
