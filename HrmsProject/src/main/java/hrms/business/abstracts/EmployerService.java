package hrms.business.abstracts;

import java.util.List;

import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.entities.concretes.Employer;

public interface EmployerService {
	
	DataResult<List<Employer>> getAll();
	
	Result add(Employer employer);

}
