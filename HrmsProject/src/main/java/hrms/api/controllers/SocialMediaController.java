package hrms.api.controllers;

import hrms.business.abstracts.SocialMediaService;
import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.entities.concretes.LinkType;
import hrms.entities.concretes.SocialMedia;
import hrms.entities.concretes.WorkplaceCandidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/socialMedias")
public class SocialMediaController {

    private SocialMediaService socialMediaService;

    @Autowired
    public SocialMediaController(SocialMediaService socialMediaService) {
        this.socialMediaService = socialMediaService;
    }

    @GetMapping("/getall")
    public DataResult<List<SocialMedia>> getAll() {
        return this.socialMediaService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody SocialMedia socialMedia) {
        return this.socialMediaService.add(socialMedia);
    }

    @GetMapping("/getByCandidateId")
    public DataResult<List<SocialMedia>> getByCandidateId(@RequestParam int candidateId){
        return socialMediaService.getByCandidateId(candidateId);
    }

}
