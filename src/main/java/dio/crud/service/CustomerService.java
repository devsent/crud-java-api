package dio.crud.service;

import dio.crud.model.Customer;

/**
 * Interface that acts as a contract for all other classes that implement
 * its methods.
 *
 * @author devsent
 */

public interface CustomerService {
        Iterable<Customer> findAll();
        Customer findById(Long id);
        void create(Customer customer);
        void update(Long id, Customer customer);
        void delete(Long id);
}
