package HrmsProject.business.abstracts;

import java.util.List;

import HrmsProject.core.utilities.results.DataResult;
import HrmsProject.core.utilities.results.Result;
import HrmsProject.entities.concretes.Employer;

public interface EmployerService {
	
	DataResult<List<Employer>> getAll();
	
	Result add (Employer employer);

}
