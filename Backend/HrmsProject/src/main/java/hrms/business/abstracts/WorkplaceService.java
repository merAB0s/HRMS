package hrms.business.abstracts;

import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.entities.concretes.School;
import hrms.entities.concretes.Workplaces;

import java.util.List;

public interface WorkplaceService {

    DataResult<List<Workplaces>> getAll();

    Result add(Workplaces workplaces);
}
