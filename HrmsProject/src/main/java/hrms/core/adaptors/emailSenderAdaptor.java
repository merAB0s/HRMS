package hrms.core.adaptors;

import org.springframework.stereotype.Service;

import hrms.zEmailVerification.emailSender;

@Service
public class emailSenderAdaptor implements emailAdaptor {

	emailSender emailS = new emailSender();

	@Override
	public boolean emailSend(String email) {
		return emailS.emailVerification(email);
	}

}

// private emailSender ile yapılcak = eemail sender