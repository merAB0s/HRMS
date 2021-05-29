package hrms.FakeMernis;

import hrms.entities.concretes.Candidate;

public interface UserValidationService {

	public boolean validate(Candidate candidate);
}