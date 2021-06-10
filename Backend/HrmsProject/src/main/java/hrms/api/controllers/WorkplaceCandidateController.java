package hrms.api.controllers;

import hrms.business.abstracts.WorkplaceCandidateService;
import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.entities.concretes.SchoolDepartment;
import hrms.entities.concretes.WorkplaceCandidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/workplacecandidates")
public class WorkplaceCandidateController {

    private WorkplaceCandidateService workplaceCandidateService;
    @Autowired
    public WorkplaceCandidateController(WorkplaceCandidateService workplaceCandidateService) {
        this.workplaceCandidateService = workplaceCandidateService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(workplaceCandidateService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody WorkplaceCandidate workplaceCandidate){
        return ResponseEntity.ok(workplaceCandidateService.add(workplaceCandidate));
    }

    @GetMapping("/getByCandidateId")
    public ResponseEntity<?> getByCandidateId(@RequestParam int candidateId){
        return ResponseEntity.ok(workplaceCandidateService.getByCandidateId(candidateId));
    }

    @GetMapping("/getByCandidateIdOrderByDateOfQuitDesc")
    public ResponseEntity<?> getByCandidateIdOrderByDateOfQuitDesc(int candidateId){
        return ResponseEntity.ok(workplaceCandidateService.getByCandidateIdOrderByDateOfQuitDesc(candidateId));
    }





}
