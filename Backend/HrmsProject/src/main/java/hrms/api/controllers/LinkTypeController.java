package hrms.api.controllers;

import hrms.business.abstracts.LinkTypeService;
import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.entities.concretes.LinkType;
import hrms.entities.concretes.Workplaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/linkTypes")
public class LinkTypeController {

    private LinkTypeService linkTypeService;
    @Autowired
    public LinkTypeController(LinkTypeService linkTypeService) {
        this.linkTypeService = linkTypeService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(linkTypeService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody LinkType linkType){
        return ResponseEntity.ok(linkTypeService.add(linkType));
    }
}
