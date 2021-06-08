package hrms.business.abstracts;

import java.util.List;

import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.entities.concretes.JobAdvertisement;
import hrms.entities.dtos.JobAdvertisementAndEmployerDto;

public interface JobAdvertisementService {
	
	DataResult<List<JobAdvertisement>> getAll();
	
	DataResult<List<JobAdvertisement>> getAllByIsActiveTrue();
	
	DataResult<List<JobAdvertisement>> getByisActiveTrueOrderByApplicationDeadlineAsc();
	
	DataResult<List<JobAdvertisement>> getByisActiveTrueAndEmployerId(int id);

	DataResult<List<JobAdvertisementAndEmployerDto>> getAdvertisementWithEmployerDetails();

	Result add(JobAdvertisement jobAdvertisement);
	
	Result update(int jobAdvertisementId , JobAdvertisement jobAdvertisement);

	
	

}
