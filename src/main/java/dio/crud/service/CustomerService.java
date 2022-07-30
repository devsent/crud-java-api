package dio.crud.service;

import dio.crud.model.Customer;
import dio.crud.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * A Service that holds all methods necessary to perform CRUD operations
 * in the "Customer" table inside the database.
 *
 * @author devsent
 */

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Iterable<Customer> findAll(){
        return customerRepository.findAll();
    };

    public Customer findById(Long id){
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.get();
    };

    public void create(Customer customer) {
        customerRepository.save(customer);
    };

    public void update(Long id, Customer customer) {
        Optional<Customer> customerToUpdate = customerRepository.findById(id);
        if (customerToUpdate.isPresent()) {
            customer.setId(customerToUpdate.get().getId());
            customerRepository.save(customer);
        }
    };

    public void delete(Long id) {
        customerRepository.deleteById(id);
    };
}
