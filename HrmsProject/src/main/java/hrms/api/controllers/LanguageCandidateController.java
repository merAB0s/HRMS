package hrms.api.controllers;

import hrms.business.abstracts.LanguageCandidateService;
import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.entities.concretes.Language;
import hrms.entities.concretes.LanguageCandidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languageCandidate")
public class LanguageCandidateController {

    private LanguageCandidateService languageCandidateService;

    @Autowired
    public LanguageCandidateController(LanguageCandidateService languageCandidateService) {
        this.languageCandidateService = languageCandidateService;
    }

    @GetMapping("/getall")
    public DataResult<List<LanguageCandidate>> getAll() {
        return this.languageCandidateService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody LanguageCandidate languageCandidate) {
        return this.languageCandidateService.add(languageCandidate);
    }




}
