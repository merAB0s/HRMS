package HrmsProject.business.abstracts;

import java.util.List;

import HrmsProject.core.utilities.results.DataResult;
import HrmsProject.core.utilities.results.Result;
import HrmsProject.entities.concretes.JobPosition;

public interface JobPositionService {
	
	DataResult<List<JobPosition>> getAll();
	Result add(JobPosition newJobPositions);

}
