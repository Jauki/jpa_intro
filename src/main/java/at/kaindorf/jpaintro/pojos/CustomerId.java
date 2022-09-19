package at.kaindorf.jpaintro.pojos;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class CustomerId implements Serializable {
    @Column(length = 1000)
    private String companyName;
    private Long customerId;
}
