package hrms.api.controllers;

import hrms.business.abstracts.AbilitiesService;
import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.entities.concretes.Abilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/abilities")
public class AbilitiesController {

    private AbilitiesService abilitiesService;

    @Autowired
    public AbilitiesController(AbilitiesService abilitiesService) {
        this.abilitiesService = abilitiesService;
    }

    @GetMapping("/getall")
    public DataResult<List<Abilities>> getAll() {
        return this.abilitiesService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Abilities abilities) {
        return this.abilitiesService.add(abilities);
    }

}
