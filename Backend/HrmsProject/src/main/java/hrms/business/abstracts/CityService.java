package hrms.business.abstracts;

import java.util.List;

import hrms.core.utilities.results.DataResult;
import hrms.entities.concretes.City;

public interface CityService {
	
	DataResult<List<City>> getAll();


}
