package at.kaindorf.jpaintro.pojos;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // if no arguments are passed AUTO is default option
    private Long customerId;
    private String firstname;
    private String lastname;
}
