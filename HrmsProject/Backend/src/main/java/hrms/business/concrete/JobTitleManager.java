package hrms.business.concrete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.business.abstracts.JobTitleService;
import hrms.core.utilities.business.BusinessRules;
import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.ErrorResult;
import hrms.core.utilities.results.Result;
import hrms.core.utilities.results.SuccessDataResult;
import hrms.core.utilities.results.SuccessResult;
import hrms.dataAccess.abstracts.JobTitleDao;
import hrms.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService {

	private JobTitleDao jobTitleDao;

	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao = jobTitleDao;
	}

	@Override
	public DataResult<List<JobTitle>> getAll() {

		return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findAll(), "Data Listelendi.");
	}

	@Override
	public Result add(JobTitle jobTitle) {
		
		Result result = BusinessRules.run(nullControl(jobTitle),titleRepeatControl(jobTitle));
		
			if(result.isSuccess()) {
				
				jobTitleDao.save(jobTitle);
				return new SuccessResult("Eklendi.");
			}
			return result;
	}

	//////////////////// KURALLAR///////////////

	private Result nullControl(JobTitle jobTitle) {

		if (jobTitle.getTitle() == null || jobTitle.getTitle().isBlank()) {
			return new ErrorResult("Alanlar Boş Bırakılamaz");
		}
		return new SuccessResult();

	}

	private Result titleRepeatControl(JobTitle jobTitle) {

		if (jobTitleDao.findAllByTitle(jobTitle.getTitle()).stream().count() != 0) {
			return new ErrorResult("Bu Pozisyon Mevcut");
		}
		return new SuccessResult();
	}

}
