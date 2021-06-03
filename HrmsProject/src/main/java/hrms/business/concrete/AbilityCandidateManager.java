package hrms.business.concrete;

import hrms.business.abstracts.AbilityCandidateService;
import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.core.utilities.results.SuccessDataResult;
import hrms.core.utilities.results.SuccessResult;
import hrms.dataAccess.abstracts.AbilityCandidatesDao;
import hrms.entities.concretes.AbilityCandidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbilityCandidateManager implements AbilityCandidateService {

    private AbilityCandidatesDao abilityCandidatesDao;

    @Autowired
    public AbilityCandidateManager(AbilityCandidatesDao abilityCandidatesDao) {
        this.abilityCandidatesDao = abilityCandidatesDao;
    }


    @Override
    public DataResult<List<AbilityCandidate>> getAll() {
        return new SuccessDataResult<List<AbilityCandidate>>(this.abilityCandidatesDao.findAll(),"Başarılı Bir Şekilde Listelendi.");
    }

    @Override
    public DataResult<List<AbilityCandidate>> getByCandidate_CandidateId(int candidateId) {
        return new SuccessDataResult<List<AbilityCandidate>>(abilityCandidatesDao.getByCandidate_Id(candidateId));
    }

    @Override
    public Result add(AbilityCandidate abilityCandidate) {
        abilityCandidatesDao.save(abilityCandidate);
        return new SuccessResult("Başarıyla Oluşturuldu.");

    }
}
