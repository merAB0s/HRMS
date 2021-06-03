package hrms.business.concrete;

import java.util.List;

import hrms.business.abstracts.*;
import hrms.entities.dtos.CvDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	private WorkplaceCandidateService workplaceCandidateService;
	private SocialMediaService socialMediaService;
	private SchoolCandidateService schoolCandidateService;
	private AbilityCandidateService abilityCandidateService;
	private LanguageCandidateService languageCandidateService;




	@Autowired
	public CandidateManager(CandidateDao candidateDao, UserValidationService validationService,
							WorkplaceCandidateService workplaceCandidateService, SocialMediaService socialMediaService,
							SchoolCandidateService schoolCandidateService, AbilityCandidateService abilityCandidateService,
							LanguageCandidateService languageCandidateService) {
		super();
		this.candidateDao = candidateDao;
		this.validationService = validationService;
		this.workplaceCandidateService = workplaceCandidateService;
		this.socialMediaService = socialMediaService;
		this.schoolCandidateService = schoolCandidateService;
		this.abilityCandidateService = abilityCandidateService;
		this.languageCandidateService = languageCandidateService;

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

	@Override
	public DataResult<CvDto> getCandidateCvByCandidateId(int candidateId) {
		CvDto cvDto = new CvDto();
		cvDto.setCandidate(this.candidateDao.findById(candidateId).get());
		cvDto.setAbilityCandidates(this.abilityCandidateService.getByCandidateId(candidateId).getData());
		cvDto.setLanguageCandidates(this.languageCandidateService.getByCandidateId(candidateId).getData());
		cvDto.setSchoolCandidates(this.schoolCandidateService.getByCandidateId(candidateId).getData());
		cvDto.setSocialMedias(this.socialMediaService.getByCandidateId(candidateId).getData());
		cvDto.setWorkplaceCandidates(this.workplaceCandidateService.getByCandidateId(candidateId).getData());
		return new SuccessDataResult<CvDto>(cvDto,"Başaryıla CV Getirildi.");
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
