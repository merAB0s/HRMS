package hrms.api.controllers;

import hrms.business.abstracts.LanguageCandidateService;
import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.entities.concretes.Language;
import hrms.entities.concretes.LanguageCandidate;
import hrms.entities.concretes.WorkplaceCandidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/languageCandidate")
public class LanguageCandidateController {

    private LanguageCandidateService languageCandidateService;
    @Autowired
    public LanguageCandidateController(LanguageCandidateService languageCandidateService) {
        this.languageCandidateService = languageCandidateService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(languageCandidateService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody LanguageCandidate languageCandiate){
        return ResponseEntity.ok(languageCandidateService.add(languageCandiate));
    }

    @GetMapping("/getByCandidateId")
    public ResponseEntity<?> getByCandidateId(@RequestParam int candidateId){
        return ResponseEntity.ok(languageCandidateService.getByCandidateId(candidateId));
    }




}
