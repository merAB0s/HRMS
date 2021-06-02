package hrms.api.controllers;

import hrms.business.abstracts.LanguageService;
import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
public class LanguageController {

    private LanguageService languageService;

    @Autowired
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }


    @GetMapping("/getall")
    public DataResult<List<Language>> getAll() {
        return this.languageService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Language language) {
        return this.languageService.add(language);
    }
}
