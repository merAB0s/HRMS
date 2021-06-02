package hrms.api.controllers;


import hrms.business.abstracts.LanguageLevelService;
import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.entities.concretes.LanguageCandidate;
import hrms.entities.concretes.LanguageLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public DataResult<List<LanguageLevel>> getAll() {
        return this.languageLevelService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody LanguageLevel languageLevel) {
        return this.languageLevelService.add(languageLevel);
    }


}
