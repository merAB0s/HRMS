package hrms.business.abstracts;

import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.entities.concretes.JobTitle;
import hrms.entities.concretes.School;

import java.util.List;

public interface SchoolService {

    DataResult<List<School>> getAll();

    Result add(School school);
}
