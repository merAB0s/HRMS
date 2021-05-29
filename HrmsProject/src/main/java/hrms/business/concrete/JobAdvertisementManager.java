package hrms.business.concrete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.business.abstracts.JobAdvertisementService;
import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.core.utilities.results.SuccessDataResult;
import hrms.core.utilities.results.SuccessResult;
import hrms.dataAccess.abstracts.JobAdvertisementDao;
import hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {
	
	private JobAdvertisementDao JobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(hrms.dataAccess.abstracts.JobAdvertisementDao jobAdvertisementDao) {
		super();
		JobAdvertisementDao = jobAdvertisementDao;
	}

	
	
	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
				
		return new SuccessDataResult<List<JobAdvertisement>>(this.JobAdvertisementDao.findAll(),"Data Listelendi.");
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		
		JobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Eklendi.");
	}

}
