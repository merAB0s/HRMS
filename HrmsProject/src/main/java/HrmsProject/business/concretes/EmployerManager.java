package HrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HrmsProject.business.abstracts.EmployerService;
import HrmsProject.business.abstracts.FieldService;
import HrmsProject.core.utilities.results.DataResult;
import HrmsProject.core.utilities.results.Result;
import HrmsProject.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {
	
	private FieldService<Employer> controllerService;
	
	@Autowired
	public EmployerManager(FieldService<Employer> controllerService) {
		super();
		this.controllerService = controllerService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return controllerService.getAll();
	}

	@Override
	public Result add(Employer employer) {
		return this.controllerService.verifyData(employer);
	}
	

}
