package dio.crud.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dio.crud.model.Customer;
import dio.crud.repository.CustomerRepository;
import dio.crud.service.CustomerService;


/**
 * A Service that holds all methods necessary to perform CRUD operations
 * in the "Customer" table inside the database.
 *
 * @author devsent
 */

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    // Returns all existing users in the database.
    @Override
    public Iterable<Customer> findAll(){
        return customerRepository.findAll();
    };

    // Checks if there is a user in the database with a specific ID.
    @Override
    public Customer findById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.get();
    }

    // Creates a new user in the database.
    @Override
    public void create(Customer customer) {
        String rawPassword = customer.getPassword();

        customer.setPassword(passwordEncoder.encode(rawPassword));
        customerRepository.save(customer);
    }

    // Updates a user in the database.
    @Override
    public void update(Long id, Customer customer) {
        Optional<Customer> dbCustomer = customerRepository.findById(id);

        if (dbCustomer.isPresent()) {
            customer.setId(dbCustomer.get().getId());

            validateUpdate(customer, id);

            customerRepository.save(customer);
        }
    }

    // Deletes a user from the database.
    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    // Validates if update request has required fields, if not, replace with the ones in the database.
    private void validateUpdate(Customer customer, Long id) {
        Optional<Customer> dbCustomer = customerRepository.findById(id);
        String name = customer.getName();
        String email = customer.getEmail();
        String password = customer.getPassword();

        if (dbCustomer.isPresent()) {
            if (name == null) {
                customer.setName(dbCustomer.get().getName());
            }

            if (email == null) {
                customer.setEmail(dbCustomer.get().getEmail());
            }

            if (password == null) {
                customer.setPassword(dbCustomer.get().getPassword());
            } else {
                customer.setPassword(passwordEncoder.encode(password));
            }
        }
    }
}
