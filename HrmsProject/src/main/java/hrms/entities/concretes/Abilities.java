package hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "abilities")
@AllArgsConstructor
@NoArgsConstructor
public class Abilities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "ability_name")
    private String abilitiyName;

    @JsonIgnore
    @OneToMany(mappedBy = "abilities")
    private List<AbilityCandidate> abilityCandidates;


}
