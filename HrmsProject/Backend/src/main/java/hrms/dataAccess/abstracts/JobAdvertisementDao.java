package hrms.dataAccess.abstracts;

import java.util.List;

import hrms.entities.dtos.JobAdvertisementAndEmployerDto;
import org.springframework.data.jpa.repository.JpaRepository;

import hrms.entities.concretes.JobAdvertisement;
import org.springframework.data.jpa.repository.Query;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
	
	List<JobAdvertisement> getByisActiveTrue();
	
	List<JobAdvertisement> getByisActiveTrueOrderByApplicationDeadlineAsc();
	
	List<JobAdvertisement> getByisActiveTrueAndEmployer_Id(int id);

	//@Query("select new hrms.entities.dtos.JobAdvertisementAndEmployerDto(e.companyName,t.title,j.quota,j.applicationDeadline,j.createdDate) fromJobAdvertisement j inner join j.employer e inner join j.jobTitle t inner join j.city c")
	//<JobAdvertisementAndEmployerDto> getAdvertisementWithEmployerDetails();

	@Query("select new hrms.entities.dtos.JobAdvertisementAndEmployerDto(e.companyName,t.title,j.quota,j.applicationDeadline,j.createdDate) " +
			"from JobAdvertisement j inner join j.employer e inner join j.jobTitle t inner join j.city c")
	List<JobAdvertisementAndEmployerDto> getAdvertisementWithEmployerDetails();
	
	
}
