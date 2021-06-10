package hrms.api.controllers;

import hrms.business.abstracts.ActivationCodeService;
import hrms.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/activationCodes")
public class ActivationCodeController {

    private ActivationCodeService activationCodeService;
    @Autowired
    public ActivationCodeController(ActivationCodeService activationCodeService) {
        this.activationCodeService = activationCodeService;
    }

    @GetMapping("/verified")
    public Result verified(String code){
        return activationCodeService.verify(code);
    }
}
