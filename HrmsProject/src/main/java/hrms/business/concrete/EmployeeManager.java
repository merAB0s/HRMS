package hrms.business.concrete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.business.abstracts.EmployeeService;
import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.core.utilities.results.SuccessDataResult;
import hrms.core.utilities.results.SuccessResult;
import hrms.dataAccess.abstracts.EmployeeDao;
import hrms.entities.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService {
	
	private EmployeeDao employeeDao;
		
	@Autowired
	public EmployeeManager(EmployeeDao employeeDao) {
			super();
			this.employeeDao = employeeDao;
		}
	
	

	@Override
	public DataResult<List<Employee>> getAll() {
		
		return new SuccessDataResult<List<Employee>>
		(employeeDao.findAll(),"Data Listelendi.");
	}

	@Override
	public Result add(Employee employee) {
		
		employeeDao.save(employee);
		return new SuccessResult("Ekledi.");
	}

}
