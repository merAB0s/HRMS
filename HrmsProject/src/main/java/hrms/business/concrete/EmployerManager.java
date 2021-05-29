package hrms.business.concrete;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import hrms.business.abstracts.EmployerService;
import hrms.core.adaptors.emailAdaptor;
import hrms.core.utilities.business.BusinessRules;
import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.ErrorResult;
import hrms.core.utilities.results.Result;
import hrms.core.utilities.results.SuccessDataResult;
import hrms.core.utilities.results.SuccessResult;
import hrms.dataAccess.abstracts.EmployerDao;
import hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private emailAdaptor adaptor;

	public EmployerManager(EmployerDao employerDao, emailAdaptor adaptor) {
		super();
		this.employerDao = employerDao;
		this.adaptor = adaptor;
	}

	@Override
	public DataResult<List<Employer>> getAll() {

		return new SuccessDataResult<List<Employer>>(employerDao.findAll(), "Data Listelendi.");

	}

	@Override
	public Result add(Employer employer) {

		Result result = BusinessRules.run(emailExist(employer.getEmail()), nullControl(employer));

		if (result.isSuccess()) {

			employerDao.save(employer);
			return new SuccessResult("Eklendi.");
		}
		return result;

	}

	
	
	
	
	//////////////////////// KURALLAR/////////////////

	
	
	private Result emailExist(String email) {

		if (employerDao.findAllByEmail(email).stream().count() != 0) {
			return new ErrorResult("Bu Email Mevcut");
		}
		return new SuccessResult();
	}

	private Result nullControl(Employer employer) {

		if (employer.getEmail() == null || employer.getEmail().isBlank() || employer.getPassword() == null
				|| employer.getPassword().isBlank() || employer.getCompanyName() == null
				|| employer.getCompanyName().isBlank() || employer.getWebAddress() == null
				|| employer.getCompanyName().isBlank()) {

			return new ErrorResult("Bu Alanlar Boş Bırakılamaz.");
		}
		return new SuccessResult();
	}

	private Result isRealEmployer(Employer employer) {

		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(employer.getEmail());

		if (!employer.getEmail().contains(employer.getWebAddress())) {
			return new ErrorResult("Domain Aynı Değil.");
		} else if (matcher.matches()) {
			return new ErrorResult("Hata");
		}
		return new SuccessResult();

	}

}
