package hrms.api.controllers;

import hrms.business.abstracts.WorkplaceCandidateService;
import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.entities.concretes.SchoolDepartment;
import hrms.entities.concretes.WorkplaceCandidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workplacecandidates")
public class WorkplaceCandidateController {

    private WorkplaceCandidateService workplaceCandidateService;

    @Autowired
    public WorkplaceCandidateController(WorkplaceCandidateService workplaceCandidateService) {
        this.workplaceCandidateService = workplaceCandidateService;
    }

    @GetMapping("/getall")
    public DataResult<List<WorkplaceCandidate>> getAll() {
        return this.workplaceCandidateService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody WorkplaceCandidate workplaceCandidate) {
        return this.workplaceCandidateService.add(workplaceCandidate);
    }

    @GetMapping("/getByCandidateId")
    public DataResult<List<WorkplaceCandidate>> getByCandidateId(@RequestParam int candidateId){
        return workplaceCandidateService.getByCandidateId(candidateId);
    }





}
