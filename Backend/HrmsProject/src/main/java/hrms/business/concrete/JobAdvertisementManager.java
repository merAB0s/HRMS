package hrms.business.concrete;

import java.time.LocalDate;
import java.util.List;

import hrms.entities.dtos.JobAdvertisementAndEmployerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.business.abstracts.JobAdvertisementService;
import hrms.core.utilities.business.BusinessRules;
import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.ErrorResult;
import hrms.core.utilities.results.Result;
import hrms.core.utilities.results.SuccessDataResult;
import hrms.core.utilities.results.SuccessResult;
import hrms.dataAccess.abstracts.CityDao;
import hrms.dataAccess.abstracts.EmployerDao;
import hrms.dataAccess.abstracts.JobAdvertisementDao;
import hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;
	private EmployerDao employerDao;
	private CityDao cityDao;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, EmployerDao employerDao, CityDao cityDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.employerDao = employerDao;
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllByIsActiveTrue() {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.getByisActiveTrue());
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByisActiveTrueOrderByApplicationDeadlineAsc() {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.getByisActiveTrueOrderByApplicationDeadlineAsc());
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByisActiveTrueAndEmployerId(int id) {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.getByisActiveTrueAndEmployer_Id(id));
	}

	@Override
	public DataResult<List<JobAdvertisementAndEmployerDto>> getAdvertisementWithEmployerDetails() {
		return new SuccessDataResult<List<JobAdvertisementAndEmployerDto>>(this.jobAdvertisementDao.getAdvertisementWithEmployerDetails());
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {

		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(), "Data Listelendi.");
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {

		Result result = BusinessRules.run(employerControl(jobAdvertisement.getEmployer().getId()),
				cityControl(jobAdvertisement.getCity().getId()),
				NullControl(jobAdvertisement),
				minSalaryControl(jobAdvertisement),
				quotaControl(jobAdvertisement),
				advertisementDateRequirement(jobAdvertisement),
				minEqualsMaxControl(jobAdvertisement));

		if (result.isSuccess()) {

			jobAdvertisementDao.save(jobAdvertisement);
			return new SuccessResult("Ba??ar??l?? Bir ??ekilde Eklendi.");
		}
		return result;
		
	}
	
	@Override
	public Result update(int jobAdvertisementId, JobAdvertisement jobAdvertisement) {
		
		Result result = BusinessRules.run(checkApplicationDeadline(jobAdvertisementId, jobAdvertisement));
		
		if(result.isSuccess()) {
			
			jobAdvertisementDao.save(jobAdvertisement);
			return new SuccessResult("Ba??ar??yla G??ncellendi.");
		}
		return result;
	}

	/////////////////////// KURALLAR//////////////////////////////////

	private Result employerControl(int id) {
		if (!employerDao.existsById(id)) {
			return new ErrorResult("B??yle Bir Kullan??c?? Yok.");
		}
		return new SuccessResult();
	}

	private Result cityControl(int id) {
		if (!cityDao.existsById(id)) {
			return new ErrorResult("B??yle bir ??ehir Yok!");
		}
		return new SuccessResult();
	}

	private Result NullControl(JobAdvertisement jobAdvertisement) {
		if (jobAdvertisement.getDescription() == null || jobAdvertisement.getDescription().isBlank()) {
			return new ErrorResult("???? Tan??m?? Alan?? BO?? Olamaz!");
		} else if (jobAdvertisement.getMinSalary() == null || jobAdvertisement.getMaxSalary() == null) {
			return new ErrorResult("Maa?? Alanlar?? DOLDURULMALIDIR..");
		} else if (jobAdvertisement.getApplicationDeadline() == null) {
			return new ErrorResult("Son Ba??vuru Tarihi BO?? B??rak??lamaz!");
		}
		return new SuccessResult();
	}

	private Result minSalaryControl(JobAdvertisement jobAdvertisement) {
		if (jobAdvertisement.getMinSalary()<2820) {
			return new ErrorResult("Minimum Maa?? Giri??i Asgari ??cretten AZ Olamaz! - Asgari ??cret: 2820");
		}
		return new SuccessResult();
	}

	private Result quotaControl(JobAdvertisement jobAdvertisement) {
		if (jobAdvertisement.getMinSalary() > jobAdvertisement.getMaxSalary()) {
			return new ErrorResult("Minimum Maa?? Maximum Maa??tan B??Y??K Olamaz!");
		}
		return new SuccessResult();
	}

	private Result minEqualsMaxControl(JobAdvertisement jobAdvertisement) {
		if (jobAdvertisement.getMaxSalary() != jobAdvertisement.getMaxSalary()) {
			return new ErrorResult("Minimmu Maa?? Maximim Maa?? ??le E????T Olamaz!");
		}
		return new SuccessResult();
	}
	
		
	private Result advertisementDateRequirement(JobAdvertisement jobAdvertisement) {
		if (jobAdvertisement.getApplicationDeadline().isBefore(LocalDate.now())) {
			return new ErrorResult("Son Ba??uru Tarihi ??uan ki Tarihten Ge?? Olamaz!");
		}
		return new SuccessResult();
	}
	
	
	
	//////////////////UPDATE/KURALLARI/////////
	
	
	private Result checkApplicationDeadline(int jobAdvertisementId, JobAdvertisement jobAdvertisement) {
		
		JobAdvertisement result = jobAdvertisementDao.findById(jobAdvertisementId).get();
		
		result.setActive(jobAdvertisement.isActive());
		
		
		if(jobAdvertisement.getApplicationDeadline().isBefore(LocalDate.now())) {
				return new ErrorResult("??lan??n Tarihi Ge??mi??!");
		}
		return new SuccessResult();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
