package hrms.business.concrete;

import hrms.business.abstracts.SchoolDepartmentService;
import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.core.utilities.results.SuccessDataResult;
import hrms.core.utilities.results.SuccessResult;
import hrms.dataAccess.abstracts.SchoolDepartmentDao;
import hrms.entities.concretes.Department;
import hrms.entities.concretes.SchoolDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolDepartmentManager implements SchoolDepartmentService {



    private SchoolDepartmentDao schoolDepartmentDao;

    @Autowired
    public SchoolDepartmentManager(SchoolDepartmentDao schoolDepartmentDao) {
        this.schoolDepartmentDao = schoolDepartmentDao;
    }


    @Override
    public DataResult<List<SchoolDepartment>> getAll() {
        return new SuccessDataResult<List<SchoolDepartment>>(this.schoolDepartmentDao.findAll());

    }

    @Override
    public Result add(SchoolDepartment schoolDepartment) {
        schoolDepartmentDao.save(schoolDepartment);
        return new SuccessResult("Başarıyla Eklendi.");
    }
}
