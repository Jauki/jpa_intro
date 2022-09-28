package at.kaindorf.jpaintro.pojos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Entity(name = "player")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player implements Serializable {
    @Id
    @GeneratedValue
    private Long playerId;
    private String firstname;
    private String lastname;
    private Integer number;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    public Player(String firstname, String lastname, Integer number) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.number = number;
    }


}
