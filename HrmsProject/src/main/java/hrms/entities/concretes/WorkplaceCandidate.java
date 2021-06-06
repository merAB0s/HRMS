package hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "workplace_candidate")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class WorkplaceCandidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private int id;

    @ManyToOne()
    @JoinColumn(name = "workplaces_id")
    private Workplaces workplace;

    @ManyToOne()
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    @ManyToOne()
    @JoinColumn(name="job_title_id")
    private JobTitle jobTitle;

    @Column(name = "date_of_entry")
    private LocalDate dateOfEntry;

    @Column(name = "date_of_quit")
    private LocalDate dateOfQuit;



}
