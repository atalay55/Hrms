package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;


public interface BaseService<T> {
	
	Result add(T item);
	Result delete(T item);
	DataResult<List<T>> getAll();
//	DataResult<T> getById(int id);

}
