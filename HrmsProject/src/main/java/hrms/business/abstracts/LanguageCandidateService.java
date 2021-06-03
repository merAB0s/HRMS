package hrms.business.abstracts;

import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.entities.concretes.AbilityCandidate;
import hrms.entities.concretes.LanguageCandidate;

import java.util.List;

public interface LanguageCandidateService {

    DataResult<List<LanguageCandidate>> getAll();

    DataResult<List<LanguageCandidate>> getByCandidateId(int candidateId);

    Result add(LanguageCandidate languageCandidate);
}
