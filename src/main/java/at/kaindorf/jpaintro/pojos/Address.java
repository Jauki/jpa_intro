package at.kaindorf.jpaintro.pojos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "address_id")
    private Long addressId;
    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
    private String number;
    @Column(name = "zip_code", nullable = false)
    private Integer zip;
}
