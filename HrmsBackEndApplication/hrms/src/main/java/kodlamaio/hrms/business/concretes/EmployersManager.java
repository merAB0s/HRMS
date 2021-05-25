package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployersService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployersDao;
import kodlamaio.hrms.entities.concretes.Employers;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class EmployersManager implements EmployersService {

	private EmployersDao employersDao;
	private User user;

	@Autowired
	public EmployersManager(EmployersDao employersDao) {
		super();
		this.employersDao = employersDao;
	}

	@Override
	public Result add(Employers employers) {
		this.employersDao.save(employers);
		return new SuccessResult("İş Veren Eklendi. ID: " + user.getId() + " Şirket Adı: " + 
		employers.getCompanyName() + " Şirket Web Sitesi: " + employers.getWebAdress());
	}

	@Override
	public DataResult<List<Employers>> getAll() {
		return new SuccessDataResult<>(this.employersDao.findAll(),"Data Listelendi.");
	}

}
