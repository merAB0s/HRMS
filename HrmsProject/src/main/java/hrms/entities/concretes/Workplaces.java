package hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "workplaces")
@AllArgsConstructor
@NoArgsConstructor
public class Workplaces {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "workplaces_name")
    private String workplaceName;

    @JsonIgnore
    @OneToMany(mappedBy = "workplace")
    private List<WorkplaceCandidate> workplaceCandidates;


}
