package at.kaindorf.jpaintro.pojos;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Entity(name = "customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
//@IdClass(CustomerId.class)
public class Customer implements Serializable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO) // if no arguments are passed AUTO is default option
//    @Column(name = "customer_id")
//    private Long customerId;

//    @Id
//    private String companyName;
//    @Id
//    private Long customerId;

    @EmbeddedId
    private CustomerId customerId;

    @Column(length = 100, nullable = false)
    @Basic(fetch = FetchType.LAZY) // LAZY => wird erst dann geholt wenn er benötigt wird
    private String firstname;
    @Column(length = 100, nullable = false)
    private String lastname;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @Enumerated(EnumType.STRING) // Ordinal => Integer; String => String
    private Gender gender;

    @OneToOne
    @JoinColumn(name="address")
    private Address address;

}
