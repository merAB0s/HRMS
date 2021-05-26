package HrmsProject.business.required;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HrmsProject.business.abstracts.FieldService;
import HrmsProject.core.utilities.results.DataResult;
import HrmsProject.core.utilities.results.ErrorResult;
import HrmsProject.core.utilities.results.Result;
import HrmsProject.core.utilities.results.SuccessDataResult;
import HrmsProject.core.utilities.results.SuccessResult;
import HrmsProject.dataAccess.abstracts.JobPositionDao;
import HrmsProject.entities.concretes.JobPosition;

@Service
public class JobTitleFieldManager implements FieldService<JobPosition> {
	
	@Autowired
	private JobPositionDao jobPositionDao;
	
	public JobTitleFieldManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	
	@Override
	public Result verifyData(JobPosition jobPosition) {
		if (jobPositionDao.existsByPosition(jobPosition.getPosition())) {
			return new ErrorResult("Bu Pozisyon Daha Önce Kaydedildi");
		}
		
			this.jobPositionDao.save(jobPosition);
			return new SuccessResult("Kayıt Eklendi");
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(),"Listeleme Başarılı");
	}

}
