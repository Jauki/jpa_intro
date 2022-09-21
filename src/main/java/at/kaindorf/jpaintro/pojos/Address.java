package at.kaindorf.jpaintro.pojos;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Address implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "address_id")
    private Long addressId;
    @Column(nullable = false)
    @NonNull
    private String street;
    @Column(nullable = false)
    @NonNull
    private String number;
    @Column(name = "zip_code", nullable = false)
    @NonNull
    private Integer zip;

    @OneToOne(mappedBy = "address")
    @ToString.Exclude
    private Customer customer;
}
