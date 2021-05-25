package kodlamaio.HrmsProject.api.controllers;

import kodlamaio.HrmsProject.business.abstracts.PositionService;
import kodlamaio.HrmsProject.core.utilities.results.DataResult;
import kodlamaio.HrmsProject.entities.concretes.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/positions")
public class PositionController {
    private final PositionService positionService;

    @Autowired
    public PositionController(PositionService positionService) {
        super();
        this.positionService = positionService;
    }

    @GetMapping("/getallpositions")
    public DataResult<List<Position>> getAll() {
        return this.positionService.getAll();
    }

}

