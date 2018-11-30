package mandatory.two.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;

/**
 * Created by Matthias Skou 30/11/2018
 */

@Entity
public class Customer extends User {

    private Long payment;

}
