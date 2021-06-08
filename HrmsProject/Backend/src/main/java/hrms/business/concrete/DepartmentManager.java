package hrms.business.concrete;

import hrms.business.abstracts.DepartmentService;
import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.core.utilities.results.SuccessDataResult;
import hrms.core.utilities.results.SuccessResult;
import hrms.dataAccess.abstracts.DepartmentDao;
import hrms.entities.concretes.Department;
import hrms.entities.concretes.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentManager implements DepartmentService {

    private DepartmentDao departmentDao;

    @Autowired
    public DepartmentManager(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }


    @Override
    public DataResult<List<Department>> getAll() {
        return new SuccessDataResult<List<Department>>(this.departmentDao.findAll());
    }

    @Override
    public Result add(Department department) {
        departmentDao.save(department);
        return new SuccessResult("Başarıyla Eklendi.");
    }
}
