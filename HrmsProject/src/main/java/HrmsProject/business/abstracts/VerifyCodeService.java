package HrmsProject.business.abstracts;

import HrmsProject.core.utilities.results.Result;
import HrmsProject.entities.concretes.User;

public interface VerifyCodeService {

	String createVerifyCode(User user);
	Result sendMail(String mail);
	Result verifyUser(String code); 
	
	
}