package hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "ability_candidates")
@AllArgsConstructor
@NoArgsConstructor
public class AbilityCandidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private int id;

    @ManyToOne()
    @JoinColumn(name = "ability_id")
    private Abilities abilities;

    @ManyToOne()
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;


}
