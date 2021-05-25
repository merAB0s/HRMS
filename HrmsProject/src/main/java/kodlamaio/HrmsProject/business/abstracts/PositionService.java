package kodlamaio.HrmsProject.business.abstracts;

import kodlamaio.HrmsProject.core.utilities.results.DataResult;
import kodlamaio.HrmsProject.entities.concretes.Position;

import java.util.List;

public interface PositionService {
    DataResult<List<Position>> getAll();


}
