package hrms.business.abstracts;

import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.entities.concretes.Abilities;

import java.util.List;

public interface AbilitiesService {

    DataResult<List<Abilities>> getAll();

    Result add(Abilities ability);
}
