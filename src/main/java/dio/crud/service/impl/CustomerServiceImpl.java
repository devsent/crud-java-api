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

    @Override
    public Iterable<Customer> findAll(){
        return customerRepository.findAll();
    };

    @Override
    public Customer findById(Long id){
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.get();
    }

    @Override
    public void create(Customer customer) {
        String rawPassword = customer.getPassword();
        customer.setPassword(passwordEncoder.encode(rawPassword));
        customerRepository.save(customer);
    }

    @Override
    public void update(Long id, Customer customer) {
        Optional<Customer> customerToUpdate = customerRepository.findById(id);
        if (customerToUpdate.isPresent()) {
            customer.setId(customerToUpdate.get().getId());
            customerRepository.save(customer);
        }
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }
}
