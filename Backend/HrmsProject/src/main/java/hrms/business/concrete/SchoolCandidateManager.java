package hrms.business.concrete;

import hrms.business.abstracts.SchoolCandidateService;
import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.core.utilities.results.SuccessDataResult;
import hrms.core.utilities.results.SuccessResult;
import hrms.dataAccess.abstracts.SchoolCandidateDao;
import hrms.entities.concretes.SchoolCandidate;
import hrms.entities.concretes.SchoolDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolCandidateManager implements SchoolCandidateService {


    private SchoolCandidateDao schoolCandidateDao;

    @Autowired
    public SchoolCandidateManager(SchoolCandidateDao schoolCandidateDao) {
        this.schoolCandidateDao = schoolCandidateDao;
    }


    @Override
    public DataResult<List<SchoolCandidate>> getAll() {
        return new SuccessDataResult<List<SchoolCandidate>>(this.schoolCandidateDao.findAll());
    }

    @Override
    public DataResult<List<SchoolCandidate>> getByCandidateId(int candidateId) {
        return new SuccessDataResult<List<SchoolCandidate>>(schoolCandidateDao.getByCandidate_Id(candidateId));
    }

    @Override
    public Result add(SchoolCandidate schoolCandidate) {
        schoolCandidateDao.save(schoolCandidate);
        return new SuccessResult("Başarıyla Eklendi.");
    }

    @Override
    public DataResult<List<SchoolCandidate>> getByCandidateIdOrderByDateOfGraduationDesc(int candidateId) {
        return new SuccessDataResult<List<SchoolCandidate>>(schoolCandidateDao.getByCandidate_IdOrderByDateOfGraduataion(candidateId));
    }
}
