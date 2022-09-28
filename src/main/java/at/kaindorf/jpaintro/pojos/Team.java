package at.kaindorf.jpaintro.pojos;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "team")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Team implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "team_id", nullable = false)
    private Long teamId;
    private String name;
    private LocalDate founded;

    // orphan -> Objekt ohne Reference, bei true wird mitgelöscht
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "team")
    @ToString.Exclude
    private List<Player> playerList = new ArrayList<>();


    public Team(String name, LocalDate founded) {
        this.name = name;
        this.founded = founded;
    }

    public void addPlayer(Player player) {
        if(!playerList.contains(player)){
            player.setTeam(this); // Important: Set Team-Reference to Player-Object
            playerList.add(player);
        }
    }
}
