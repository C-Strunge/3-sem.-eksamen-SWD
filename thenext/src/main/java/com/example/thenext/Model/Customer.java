package com.example.thenext.Model;

import javax.persistence.Entity;

/**
 * Created by Matthias Skou 30/11/2018
 */

@Entity
public class Customer extends User {

    private Long payment;

}
