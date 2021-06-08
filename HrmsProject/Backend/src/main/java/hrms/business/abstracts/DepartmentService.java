package hrms.business.abstracts;

import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.entities.concretes.Department;

import java.util.List;

public interface DepartmentService {

    DataResult<List<Department>> getAll();

    Result add(Department department);
}
