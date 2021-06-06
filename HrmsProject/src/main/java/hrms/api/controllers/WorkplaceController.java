package hrms.api.controllers;

import hrms.business.abstracts.WorkplaceService;
import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.entities.concretes.School;
import hrms.entities.concretes.Workplaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/workplaces")
public class WorkplaceController {

    private WorkplaceService workplaceService;
    @Autowired
    public WorkplaceController(WorkplaceService workplaceService) {
        this.workplaceService = workplaceService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(workplaceService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody Workplaces workplace){
        return ResponseEntity.ok(workplaceService.add(workplace));
    }

}
