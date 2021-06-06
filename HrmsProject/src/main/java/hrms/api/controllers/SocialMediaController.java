package hrms.api.controllers;

import hrms.business.abstracts.SocialMediaService;
import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.entities.concretes.LinkType;
import hrms.entities.concretes.SocialMedia;
import hrms.entities.concretes.WorkplaceCandidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/socialMedias")
public class SocialMediaController {

    private SocialMediaService socialMediaService;
    @Autowired
    public SocialMediaController(SocialMediaService socialMediaService) {
        this.socialMediaService = socialMediaService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(socialMediaService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody SocialMedia socialMedia){
        return ResponseEntity.ok(socialMediaService.add(socialMedia));
    }

    @GetMapping("/getByCandidateId")
    public ResponseEntity<?> getByCandidateId(@RequestParam int candidateId){
        return ResponseEntity.ok(socialMediaService.getByCandidateId(candidateId));
    }

}
