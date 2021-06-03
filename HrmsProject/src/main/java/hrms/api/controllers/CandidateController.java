package hrms.api.controllers;

import hrms.business.abstracts.CandidateService;
import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.entities.concretes.Candidate;
import hrms.entities.dtos.CvDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

	private CandidateService candidateService;

	@Autowired
	public CandidateController(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}

	@GetMapping("/getall")
	public DataResult<List<Candidate>> getAll() {

		return candidateService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody Candidate candidate) {

		return candidateService.add(candidate);
	}

	@GetMapping("/getCandidateCvByCandidateId")
	public DataResult<CvDto> getCandidateCvByCandidateId(int candidateId) {
		return candidateService.getCandidateCvByCandidateId(candidateId);
	}


}
