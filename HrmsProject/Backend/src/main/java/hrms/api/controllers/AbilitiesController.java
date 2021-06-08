package hrms.api.controllers;

import hrms.business.abstracts.AbilitiesService;
import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.entities.concretes.Abilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(abilitiesService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Abilities abilities) {
        return ResponseEntity.ok(abilitiesService.add(abilities));
    }

}
