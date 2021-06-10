package hrms.business.abstracts;

import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.entities.concretes.SchoolDepartment;

import java.util.List;

public interface SchoolDepartmentService  {

    DataResult<List<SchoolDepartment>> getAll();

    Result add(SchoolDepartment schoolDepartment);
}
