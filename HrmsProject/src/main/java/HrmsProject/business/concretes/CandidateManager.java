package HrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HrmsProject.business.abstracts.CandidateService;
import HrmsProject.business.abstracts.FieldService;
import HrmsProject.core.utilities.results.DataResult;
import HrmsProject.core.utilities.results.Result;
import HrmsProject.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {
	
	private FieldService<Candidate> controllerService;
	
	
	@Autowired
	public CandidateManager(FieldService<Candidate> controllerService) {
		super();
		this.controllerService = controllerService;
		
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return this.controllerService.getAll();
	}
		
	@Override
	public Result add(Candidate newCandidate) {
		return this.controllerService.verifyData(newCandidate);	
	}
	


}
