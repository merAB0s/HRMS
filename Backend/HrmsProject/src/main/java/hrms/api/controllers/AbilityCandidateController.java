package hrms.api.controllers;

import hrms.business.abstracts.AbilityCandidateService;
import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.entities.concretes.AbilityCandidate;
import hrms.entities.concretes.WorkplaceCandidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/abilityCandidates")
public class AbilityCandidateController {

    private AbilityCandidateService abilityCandidateService;

    @Autowired
    public AbilityCandidateController(AbilityCandidateService abilityCandidateService) {
        this.abilityCandidateService = abilityCandidateService;
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(abilityCandidateService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody AbilityCandidate abilityCandidate) {
        return ResponseEntity.ok(abilityCandidateService.add(abilityCandidate));
    }

    @GetMapping("/getByCandidateId")
    public ResponseEntity<?> getByCandidateId(@RequestParam int candidateId){
        return ResponseEntity.ok(abilityCandidateService.getByCandidateId(candidateId));
    }


}
