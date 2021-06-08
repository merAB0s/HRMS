package hrms.api.controllers;

import hrms.business.abstracts.CandidateService;
import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.entities.concretes.Candidate;
import hrms.entities.dtos.CvDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
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
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(candidateService.getAll());
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody Candidate candidate) {
		return ResponseEntity.ok(candidateService.add(candidate));
	}

	@GetMapping("/getCandidateCvByCandidateId")
	public ResponseEntity<?> getCandidateCvByCandidateId(int candidateId){
		return ResponseEntity.ok(candidateService.getCandidateCvByCandidateId(candidateId));
	}


}
