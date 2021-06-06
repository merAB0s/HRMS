package hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@Table(name = "schools")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","schoolDepartments"})
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private int id;

    @NotBlank
    @NotNull
    @Column(name = "school_name")
    private String schoolName;

    @JsonIgnore
    @OneToMany(mappedBy = "school")
    private List<SchoolDepartment> schoolDepartments;
}
