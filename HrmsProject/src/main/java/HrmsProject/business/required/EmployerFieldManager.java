package HrmsProject.business.required;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HrmsProject.business.abstracts.FieldService;
import HrmsProject.core.utilities.results.DataResult;
import HrmsProject.core.utilities.results.ErrorResult;
import HrmsProject.core.utilities.results.Result;
import HrmsProject.core.utilities.results.SuccessDataResult;
import HrmsProject.core.utilities.results.SuccessResult;
import HrmsProject.dataAccess.abstracts.EmployerDao;
import HrmsProject.dataAccess.abstracts.UserDao;
import HrmsProject.entities.concretes.Employer;

@Service
public class EmployerFieldManager implements FieldService<Employer> {

	@Autowired
	private EmployerDao employerDao;
	private UserDao userDao;
	
	public EmployerFieldManager(EmployerDao employerDao, UserDao userDao) {
		super();
		this.employerDao = employerDao;
		this.userDao = userDao;
	}
	
	
	@Override
	public Result verifyData(Employer employer) {
		String[] splitMail = employer.getMail().split("@");
		if (!splitMail[1].equals(employer.getWebAddress())) {
			return new ErrorResult("Yalnızca Şirket Web Sitenizin Uzantısına Sahip Bir Mail Adresiyle Kayıt Olabilirsiniz");
		}
		if (this.userDao.existsByMail(employer.getMail())) {
			return new ErrorResult("Mail Adresi Daha Önce Kullanıldı");
		}
		if (employer.getPassword().equals(employer.getPasswordRepeat()) == false) {
			return new ErrorResult("Şifreler Uyuşmuyor");
		}
		this.employerDao.save(employer);
		return new SuccessResult("Kayıt Başarılı");
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"Listeleme Başarılı");
	}

}
