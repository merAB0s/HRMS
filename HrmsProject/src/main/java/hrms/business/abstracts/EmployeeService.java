package hrms.business.abstracts;

import java.util.List;

import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.entities.concretes.Employee;

public interface EmployeeService {
	
		DataResult<List<Employee>> getAll();
		
		Result add(Employee employee);
}
