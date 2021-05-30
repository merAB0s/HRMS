package hrms.business.concrete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.business.abstracts.CandidateService;
import hrms.core.utilities.business.BusinessRules;
import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.ErrorResult;
import hrms.core.utilities.results.Result;
import hrms.core.utilities.results.SuccessDataResult;
import hrms.core.utilities.results.SuccessResult;
import hrms.dataAccess.abstracts.CandidateDao;
import hrms.entities.concretes.Candidate;
import hrms.zFakeMernis.UserValidationService;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private UserValidationService validationService;

	@Autowired
	public CandidateManager(CandidateDao candidateDao, UserValidationService validationService) {
		super();
		this.candidateDao = candidateDao;
		this.validationService = validationService;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {

		return new SuccessDataResult<List<Candidate>>(candidateDao.findAll(), "Data Listelendi.");
	}

	@Override
	public Result add(Candidate candidate) {

		Result result = BusinessRules.run(identityNumberControl(candidate));

		if (result.isSuccess()) {

			candidateDao.save(candidate);
			return new SuccessResult("Eklendi.");
		}
		return result;

	}

	///////////////// KURALLAR////////////////////////

	private Result mernisControl(Candidate candidate) {

		if (validationService.validate(candidate) == false) {
			return new ErrorResult("Mernis doğrulaması gerçekleşmedi");
		}
		return new SuccessResult();
	}

	private Result identityNumberControl(Candidate candidate) {

		if (candidate.getIdentificationNumber().length() != 11) {
			return new ErrorResult("Tc Numarası 11 Haneli Olmalıdır.");
		}
		return new SuccessResult();
	}

}
