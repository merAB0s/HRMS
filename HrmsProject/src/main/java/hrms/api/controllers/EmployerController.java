package hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.business.abstracts.EmployerService;
import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employers")
public class EmployerController {
	
	private EmployerService employerService;

	public EmployerController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}
	
	
	@GetMapping("/getall")
	public DataResult<List<Employer>> getAll() {
		
		return employerService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Employer employer) {
		
		return employerService.add(employer);
		
	}

}
