package hrms.api.controllers;

import java.util.List;

import hrms.entities.dtos.JobAdvertisementAndEmployerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import hrms.business.abstracts.JobAdvertisementService;
import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.entities.concretes.JobAdvertisement;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/jobAdvertisements")
public class JobAdvertisementController {

	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}

	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.jobAdvertisementService.getAll());
	}

	@GetMapping("/getAllByIsActiveTrue")
	public ResponseEntity<?> getAllByIsActiveTrue(){
		return ResponseEntity.ok(this.jobAdvertisementService.getAllByIsActiveTrue());
	}

	@GetMapping("/getByisActiveTrueOrderByApplicationDeadlineAsc")
	public ResponseEntity<?> getByisActiveTrueOrderByApplicationDeadlineAsc(){
		return ResponseEntity.ok(this.jobAdvertisementService.getByisActiveTrueOrderByApplicationDeadlineAsc());
	}

	@GetMapping("/getByisActiveTrueAndEmployerId")
	public ResponseEntity<?> getByisActiveTrueAndEmployerId(int id){
		return ResponseEntity.ok(this.jobAdvertisementService.getByisActiveTrueAndEmployerId(id));
	}

	@GetMapping("/getAdvertisementWithEmployerDetails")
	public ResponseEntity<?> getAdvertisementWithEmployerDetails(){
		return ResponseEntity.ok(this.jobAdvertisementService.getAdvertisementWithEmployerDetails());
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody JobAdvertisement jobAdvertisement){
		return ResponseEntity.ok(this.jobAdvertisementService.add(jobAdvertisement));
	}

	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestParam int id,@Valid @RequestBody JobAdvertisement jobAdvertisement){
		return ResponseEntity.ok(this.jobAdvertisementService.update(id , jobAdvertisement));
	}


	
	
	
	

}
