package hrms.entities.concretes;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_advertisements")
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer;

	@ManyToOne()
	@JoinColumn(name = "job_title_id")
	private JobTitle jobTitle;

	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;

	@NotBlank
	@NotNull
	@Column(name = "description", length = 2500)
	@Type(type="text")
	private String description;

	@NotBlank
	@NotNull
	@Column(name = "min_salary")
	private Double minSalary;

	@NotBlank
	@NotNull
	@Column(name = "max_salary")
	private Double maxSalary;

	@NotBlank
	@NotNull
	@Column(name = "quota")
	private int quota;

	@NotBlank
	@NotNull
	@Column(name = "application_deadline")
	private LocalDate applicationDeadline;

	@Column(name="created_date")
	private LocalDateTime createdDate;
	
	@Column(name="is_active")
	private boolean isActive;

}
