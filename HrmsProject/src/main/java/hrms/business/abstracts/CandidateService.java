package hrms.business.abstracts;

import java.util.List;

import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.entities.concretes.Candidate;

public interface CandidateService {
		
		DataResult<List<Candidate>> getAll();
		
		Result add(Candidate candidate);
		
		
}	
	