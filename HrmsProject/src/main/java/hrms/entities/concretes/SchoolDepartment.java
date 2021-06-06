package hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "school_departments")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","schoolCandidates"})
public class SchoolDepartment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private int id;

    @ManyToOne()
    @JoinColumn(name = "school_id")
    private School school;

    @ManyToOne()
    @JoinColumn(name = "department_id")
    private Department department;

    @JsonIgnore
    @OneToMany(mappedBy = "schoolDepartment")
    private List<SchoolCandidate> SchoolCandidates ;
}
