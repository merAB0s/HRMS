package HrmsProject.api.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HrmsProject.business.abstracts.VerifyCodeService;
import HrmsProject.core.utilities.results.Result;
import HrmsProject.core.utilities.results.SuccessResult;
import HrmsProject.entities.concretes.VerifyCode;

@RestController
@RequestMapping("/valid")
public class VerifyCodeController {
	
	VerifyCodeService verifyCodeService;
	

	public VerifyCodeController(VerifyCodeService verifyCodeService) {
		super();
		this.verifyCodeService = verifyCodeService;
	}


	@PutMapping("/{verifyCode}")
	public Result update(@PathVariable("verifyCode") String verifyCode,	@RequestBody VerifyCode verifyingCode) {
		verifyCodeService.verifyUser(verifyCode);
		return new SuccessResult("Başarılı Kayıt");
		
		
	}

}
