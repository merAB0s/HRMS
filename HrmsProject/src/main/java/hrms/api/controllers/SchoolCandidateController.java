package hrms.api.controllers;

import hrms.business.abstracts.SchoolCandidateService;
import hrms.business.abstracts.SchoolService;
import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.entities.concretes.School;
import hrms.entities.concretes.SchoolCandidate;
import hrms.entities.concretes.SocialMedia;
import hrms.entities.concretes.WorkplaceCandidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/schoolcandidate")
public class SchoolCandidateController {

    private SchoolCandidateService schoolCandidateService;

    @Autowired
    public SchoolCandidateController(SchoolCandidateService schoolCandidateService) {
        this.schoolCandidateService = schoolCandidateService;
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.schoolCandidateService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody SchoolCandidate schoolCandidate){
        return ResponseEntity.ok(this.schoolCandidateService.add(schoolCandidate));
    }

    @GetMapping("/getByCandidateId")
    public ResponseEntity<?> getByCandidateId(@RequestParam int candidateId){
        return ResponseEntity.ok(schoolCandidateService.getByCandidateId(candidateId));
    }

    @GetMapping("/getByCandidateIdOrderByDateOfGraduationDesc")
    public ResponseEntity<?> getByCandidateIdOrderByDateOfGraduationDesc(int candidateId){
        return ResponseEntity.ok(schoolCandidateService.getByCandidateIdOrderByDateOfGraduationDesc(candidateId));
    }



}
