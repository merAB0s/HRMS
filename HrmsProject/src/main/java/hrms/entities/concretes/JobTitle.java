package hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "job_titles")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","workplaceCandidates","jobAdvertisement"})
public class JobTitle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "id")
	private int id;

	@NotBlank
	@NotNull
	@Column(name = "title")
	private String title;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobTitle")
	private List<JobAdvertisement> jobAdvertisement;

	@JsonIgnore
	@OneToMany(mappedBy = "jobTitle")
	private List<WorkplaceCandidate> workplaceCandidates;

}
