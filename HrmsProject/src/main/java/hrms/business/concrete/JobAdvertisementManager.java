package hrms.business.concrete;

import java.time.LocalDate;
import java.util.List;

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
			return new SuccessResult("Başarılı Bir Şekilde Eklendi.");
		}
		return result;
		
	}
	
	@Override
	public Result update(int jobAdvertisementId, JobAdvertisement jobAdvertisement) {
		
		Result result = BusinessRules.run(checkApplicationDeadline(jobAdvertisementId, jobAdvertisement));
		
		if(result.isSuccess()) {
			
			jobAdvertisementDao.save(jobAdvertisement);
			return new SuccessResult("Başarıyla Güncellendi.");
		}
		return result;
	}

	/////////////////////// KURALLAR//////////////////////////////////

	private Result employerControl(int id) {
		if (!employerDao.existsById(id)) {
			return new ErrorResult("Böyle Bir Kullanıcı Yok.");
		}
		return new SuccessResult();
	}

	private Result cityControl(int id) {
		if (!cityDao.existsById(id)) {
			return new ErrorResult("Böyle bir Şehir Yok!");
		}
		return new SuccessResult();
	}

	private Result NullControl(JobAdvertisement jobAdvertisement) {
		if (jobAdvertisement.getDescription() == null || jobAdvertisement.getDescription().isBlank()) {
			return new ErrorResult("İş Tanımı Alanı BOŞ Olamaz!");
		} else if (jobAdvertisement.getMinSalary() == null || jobAdvertisement.getMaxSalary() == null) {
			return new ErrorResult("Maaş Alanları DOLDURULMALIDIR..");
		} else if (jobAdvertisement.getApplicationDeadline() == null) {
			return new ErrorResult("Son Başvuru Tarihi BOŞ Bırakılamaz!");
		}
		return new SuccessResult();
	}

	private Result minSalaryControl(JobAdvertisement jobAdvertisement) {
		if (jobAdvertisement.getMinSalary()<2820) {
			return new ErrorResult("Minimum Maaş Girişi Asgari Ücretten AZ Olamaz! - Asgari Ücret: 2820");
		}
		return new SuccessResult();
	}

	private Result quotaControl(JobAdvertisement jobAdvertisement) {
		if (jobAdvertisement.getMinSalary() > jobAdvertisement.getMaxSalary()) {
			return new ErrorResult("Minimum Maaş Maximum Maaştan BÜYÜK Olamaz!");
		}
		return new SuccessResult();
	}

	private Result minEqualsMaxControl(JobAdvertisement jobAdvertisement) {
		if (jobAdvertisement.getMaxSalary() != jobAdvertisement.getMaxSalary()) {
			return new ErrorResult("Minimmu Maaş Maximim Maaş İle EŞİT Olamaz!");
		}
		return new SuccessResult();
	}
	
		
	private Result advertisementDateRequirement(JobAdvertisement jobAdvertisement) {
		if (jobAdvertisement.getApplicationDeadline().isBefore(LocalDate.now())) {
			return new ErrorResult("Son Başuru Tarihi Şuan ki Tarihten Geç Olamaz!");
		}
		return new SuccessResult();
	}
	
	
	
	//////////////////UPDATE/KURALLARI/////////
	
	
	private Result checkApplicationDeadline(int jobAdvertisementId, JobAdvertisement jobAdvertisement) {
		
		JobAdvertisement result = jobAdvertisementDao.findById(jobAdvertisementId).get();
		
		result.setActive(jobAdvertisement.isActive());
		
		
		if(jobAdvertisement.getApplicationDeadline().isBefore(LocalDate.now())) {
				return new ErrorResult("İlanın Tarihi Geçmiş!");
		}
		return new SuccessResult();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
