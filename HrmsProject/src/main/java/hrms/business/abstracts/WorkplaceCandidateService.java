package hrms.business.abstracts;

import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.entities.concretes.School;
import hrms.entities.concretes.WorkplaceCandidate;

import java.util.List;

public interface WorkplaceCandidateService {

    DataResult<List<WorkplaceCandidate>> getAll();

    Result add(WorkplaceCandidate workplaceCandidate);
}
