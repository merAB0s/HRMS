package hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.business.abstracts.EmployerService;
import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.entities.concretes.Employer;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/employers")
public class EmployerController {

	private EmployerService employerService;

	@Autowired
	public EmployerController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}

	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(employerService.getAll());
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody Employer employer) {
		return ResponseEntity.ok(employerService.add(employer));
	}


}
