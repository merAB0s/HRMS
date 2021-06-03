package hrms.business.abstracts;

import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.entities.concretes.AbilityCandidate;
import hrms.entities.concretes.School;
import hrms.entities.concretes.WorkplaceCandidate;

import java.util.List;

public interface WorkplaceCandidateService {

    DataResult<List<WorkplaceCandidate>> getAll();

    DataResult<List<WorkplaceCandidate>> getByCandidateId(int candidateId);

    Result add(WorkplaceCandidate workplaceCandidate);
}
