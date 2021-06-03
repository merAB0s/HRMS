package hrms.business.abstracts;

import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.entities.concretes.AbilityCandidate;
import hrms.entities.concretes.SchoolCandidate;

import java.util.List;

public interface SchoolCandidateService {

    DataResult<List<SchoolCandidate>> getAll();

    DataResult<List<SchoolCandidate>> getByCandidateId(int candidateId);

    Result add(SchoolCandidate schoolCandidate);
}
