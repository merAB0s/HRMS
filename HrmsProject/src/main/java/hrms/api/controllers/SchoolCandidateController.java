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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schoolcandidate")
public class SchoolCandidateController {


    private SchoolCandidateService schoolCandidateServiceService;

    @Autowired
    public SchoolCandidateController(SchoolCandidateService schoolCandidateServiceService) {
        this.schoolCandidateServiceService = schoolCandidateServiceService;
    }



    @GetMapping("/getall")
    public DataResult<List<SchoolCandidate>> getAll() {
        return this.schoolCandidateServiceService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody SchoolCandidate schoolCandidate) {
        return this.schoolCandidateServiceService.add(schoolCandidate);
    }

    @GetMapping("/getByCandidateId")
    public DataResult<List<SchoolCandidate>> getByCandidate_CandidateId(@RequestParam int candidateId){
        return schoolCandidateServiceService.getByCandidate_CandidateId(candidateId);
    }


}
