package mandatory.two.repository;

import mandatory.two.model.Company;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Matthias Skou 30/11/2018
 */

public interface CompanyRepository extends CrudRepository<Company, Long> {
}
