package hrms.business.abstracts;

import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.entities.concretes.AbilityCandidate;

import java.util.List;

public interface AbilityCandidateService {

    DataResult<List<AbilityCandidate>> getAll();

    Result add(AbilityCandidate abilityCandidate);
}
