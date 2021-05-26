package HrmsProject.business.abstracts;

import java.util.List;

import HrmsProject.core.utilities.results.DataResult;
import HrmsProject.core.utilities.results.Result;
import HrmsProject.entities.concretes.Candidate;

public interface CandidateService {
	
	DataResult<List<Candidate>> getAll();
	
	Result add (Candidate candidate) ;

}
