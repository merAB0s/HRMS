package hrms.zFakeMernis;

import org.springframework.stereotype.Service;

import hrms.entities.concretes.Candidate;

@Service
public class UserValidationManager implements UserValidationService {

	@Override
	public boolean validate(Candidate candidate) {

		if (candidate.getFirstName() == "ab0" && candidate.getIdentificationNumber() == "12345678912") {
			return true;
		} else {
			return false;
		}
	}
}
