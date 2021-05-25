package kodlamaio.HrmsProject.business.abstracts;

import kodlamaio.HrmsProject.core.utilities.results.DataResult;
import kodlamaio.HrmsProject.core.utilities.results.Result;
import kodlamaio.HrmsProject.entities.concretes.Employee;

import java.util.List;

public interface EmployeeService {
    DataResult<List<Employee>> getAll();

    Result add(Employee employee);

    Result delete(Employee employee);

    Result update(Employee employee);

}
