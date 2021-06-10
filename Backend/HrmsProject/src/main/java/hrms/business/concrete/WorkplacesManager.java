package hrms.business.concrete;

import hrms.business.abstracts.WorkplaceService;
import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.core.utilities.results.SuccessDataResult;
import hrms.core.utilities.results.SuccessResult;
import hrms.dataAccess.abstracts.WorkplaceDao;
import hrms.entities.concretes.Workplaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkplacesManager implements WorkplaceService {

    private WorkplaceDao workplaceDao;

    @Autowired
    public WorkplacesManager(WorkplaceDao workplaceDao) {
        this.workplaceDao = workplaceDao;
    }


    @Override
    public DataResult<List<Workplaces>> getAll() {
        return new SuccessDataResult<List<Workplaces>>(this.workplaceDao.findAll(),"Başarıyla Listelendi.");
    }

    @Override
    public Result add(Workplaces workplaces) {
        workplaceDao.save(workplaces);
        return new SuccessResult("Başarıyla Eklendi.");
    }
}
