package hrms.business.concrete;

import hrms.business.abstracts.WorkplaceCandidateService;
import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.core.utilities.results.SuccessDataResult;
import hrms.core.utilities.results.SuccessResult;
import hrms.dataAccess.abstracts.WorkplaceCandidateDao;
import hrms.entities.concretes.WorkplaceCandidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkplaceCandidateManager implements WorkplaceCandidateService {

    private WorkplaceCandidateDao workplaceCandidateDao;

    @Autowired
    public WorkplaceCandidateManager(WorkplaceCandidateDao workplaceCandidateDao) {
        this.workplaceCandidateDao = workplaceCandidateDao;
    }


    @Override
    public DataResult<List<WorkplaceCandidate>> getAll() {
        return new SuccessDataResult<List<WorkplaceCandidate>>(this.workplaceCandidateDao.findAll(),"Başarıyla Listelendi.");
    }

    @Override
    public DataResult<List<WorkplaceCandidate>> getByCandidateId(int candidateId) {
        return new SuccessDataResult<List<WorkplaceCandidate>>(workplaceCandidateDao.getByCandidate_Id(candidateId));
    }

    @Override
    public Result add(WorkplaceCandidate workplaceCandidate) {
        workplaceCandidateDao.save(workplaceCandidate);
        return new SuccessResult("Başarıyla Eklendi.");
    }

    @Override
    public DataResult<List<WorkplaceCandidate>> getByCandidateIdOrderByDateOfQuitDesc(int candidateId) {
        return new SuccessDataResult<List<WorkplaceCandidate>>(workplaceCandidateDao.getByCandidate_IdOrderByDateOfQuitDesc(candidateId));
    }
}
