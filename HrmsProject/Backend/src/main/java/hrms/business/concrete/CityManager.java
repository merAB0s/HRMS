package hrms.business.concrete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.business.abstracts.CityService;
import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.SuccessDataResult;
import hrms.dataAccess.abstracts.CityDao;
import hrms.entities.concretes.City;

@Service
public class CityManager implements CityService {
	
	private CityDao cityDao;

	@Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}


	@Override
	public DataResult<List<City>> getAll() {
		
		return new SuccessDataResult<List<City>>(this.cityDao.findAll(),"Data Listelendi.");

	}

}
