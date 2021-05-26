package HrmsProject.business.abstracts;

import java.util.List;

import HrmsProject.core.utilities.results.DataResult;
import HrmsProject.core.utilities.results.Result;

public interface FieldService<T> {
	
	Result verifyData(T data);
	
	DataResult<List<T>> getAll();

}
