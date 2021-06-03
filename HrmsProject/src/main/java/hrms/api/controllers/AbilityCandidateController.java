package hrms.api.controllers;

import hrms.business.abstracts.AbilityCandidateService;
import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.entities.concretes.AbilityCandidate;
import hrms.entities.concretes.WorkplaceCandidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public DataResult<List<AbilityCandidate>> getAll() {
        return this.abilityCandidateService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody AbilityCandidate abilityCandidate) {
        return this.abilityCandidateService.add(abilityCandidate);
    }

    @GetMapping("/getByCandidateId")
    public DataResult<List<AbilityCandidate>> getByCandidate_CandidateId(@RequestParam int candidateId){
        return abilityCandidateService.getByCandidate_CandidateId(candidateId);
    }


}
