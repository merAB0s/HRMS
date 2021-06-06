package hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties({"hibernateLazyInitializer","handler",
		"schoolCandidates","languageCandiates",
		"abilityCandidates","workplaceCandidates",
		"socialMedias","cvDetail"})
public class Candidate extends User {

	@NotBlank
	@NotNull
	@Column(name = "first_name")
	private String firstName;

	@NotBlank
	@NotNull
	@Column(name = "last_name")
	private String lastName;

	@NotBlank
	@NotNull
	@Column(name = "identity_number")
	private String identificationNumber;

	@NotBlank
	@NotNull
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

	@JsonIgnore
	@OneToOne(mappedBy = "candidate")
	private CvDetail cvDetail;







}
