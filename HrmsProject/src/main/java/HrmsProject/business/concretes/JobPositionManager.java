package HrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HrmsProject.business.abstracts.FieldService;
import HrmsProject.business.abstracts.JobPositionService;
import HrmsProject.core.utilities.results.DataResult;
import HrmsProject.core.utilities.results.Result;
import HrmsProject.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{
	
	private FieldService<JobPosition> controllerService;
	
	
	@Autowired
	public JobPositionManager(FieldService<JobPosition> controllerService) {
		super();
		this.controllerService = controllerService;
	}
	

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return controllerService.getAll();
	}


	@Override
	public Result add(JobPosition newJobPositions) {
		return controllerService.verifyData(newJobPositions);
		}

}
