package kodlamaio.HrmsProject.business.abstracts;

import kodlamaio.HrmsProject.core.utilities.results.DataResult;
import kodlamaio.HrmsProject.core.utilities.results.Result;
import kodlamaio.HrmsProject.entities.concretes.Employer;

import java.util.List;

public interface EmployerService {
    DataResult<List<Employer>> getAll();

    Result add(Employer employer);

    Result delete(Employer employer);

    Result update(Employer employer);
}
