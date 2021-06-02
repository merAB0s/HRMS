package hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "candidates")
public class Candidate extends User {

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "identity_number")
	private String identificationNumber;

	@Column(name = "birth_date")
	private LocalDate birthDate;

	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<SchoolCandidate> SchoolCandidate ;

	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<LanguageCandidate> languageCandidates;

	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<AbilityCandidate> abilityCandidates;

	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<WorkplaceCandidate> workplaceCandidates;

	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<SocialMedia> socialMedia;




}
