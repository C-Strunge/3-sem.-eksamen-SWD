package mandatory.two.repository;

import mandatory.two.model.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Matthias Skou 30/11/2018
 */

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
