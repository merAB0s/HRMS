package hrms.business.abstracts;

import java.util.List;

import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.entities.concretes.JobTitle;

public interface JobTitleService {
	
	DataResult<List<JobTitle>> getAll();
	
	Result add(JobTitle jobTitle);

}
