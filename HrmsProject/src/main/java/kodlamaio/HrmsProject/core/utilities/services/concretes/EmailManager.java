package kodlamaio.HrmsProject.core.utilities.services.concretes;

import kodlamaio.HrmsProject.business.constants.Message;
import kodlamaio.HrmsProject.core.utilities.results.Result;
import kodlamaio.HrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.HrmsProject.core.utilities.services.abstracts.EmailService;

public class EmailManager implements EmailService {

	@Override
	public Result sendEmail() {
		return new SuccessResult(Message.EmailSend);
	}

}
