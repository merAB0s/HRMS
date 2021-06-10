package hrms.zFakeMernis;

import hrms.entities.concretes.Candidate;

public interface UserValidationService {

	public boolean validate(Candidate candidate);
}