package kodlamaio.HrmsProject.api.controllers;
import kodlamaio.HrmsProject.business.abstracts.UserService;
import kodlamaio.HrmsProject.core.entities.concretes.User;
import kodlamaio.HrmsProject.core.utilities.results.DataResult;
import kodlamaio.HrmsProject.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        super();
        this.userService = userService;
    }


    @GetMapping("/getallusers")
    public DataResult<List<User>> getAll() {
        return this.userService.getAll();
    }

    @PostMapping("/addusers")
    public Result add(@Valid @RequestBody User user) throws Exception {
        return this.userService.add(user);
    }

    @PostMapping("/updateusers")
    public Result update(@RequestBody User user) {
        return this.userService.update(user);
    }

    @PostMapping("/deleteusers")
    public Result delete(@RequestBody User user) {
        return this.userService.delete(user);
    }
}
