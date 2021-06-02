package hrms.api.controllers;

import hrms.business.abstracts.LinkTypeService;
import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.entities.concretes.LinkType;
import hrms.entities.concretes.Workplaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/linkTypes")
public class LinkTypeController {

    private LinkTypeService linkTypeService;

    @Autowired
    public LinkTypeController(LinkTypeService linkTypeService) {
        this.linkTypeService = linkTypeService;
    }

    @GetMapping("/getall")
    public DataResult<List<LinkType>> getAll() {
        return this.linkTypeService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody LinkType linkType) {
        return this.linkTypeService.add(linkType);
    }

}
