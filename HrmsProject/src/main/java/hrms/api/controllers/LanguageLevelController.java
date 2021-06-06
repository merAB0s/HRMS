package hrms.api.controllers;


import hrms.business.abstracts.LanguageLevelService;
import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.entities.concretes.LanguageCandidate;
import hrms.entities.concretes.LanguageLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/languageLevel")
public class LanguageLevelController {

    private LanguageLevelService languageLevelService;

    @Autowired
    public LanguageLevelController(LanguageLevelService languageLevelService) {
        this.languageLevelService = languageLevelService;
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(languageLevelService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody LanguageLevel languageLevel) {
        return ResponseEntity.ok(languageLevelService.add(languageLevel));
    }
}
