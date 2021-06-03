package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.database.abstracts.EmployeeDao;
import kodlamaio.hrms.entities.concretes.Employee;




@Service
public class EmployeeManager implements EmployeeService{


private EmployeeDao employeeDao;
	
	@Autowired
	public EmployeeManager(EmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}
	@Override
	public DataResult<List<Employee>>  getAll() {
		return  new SuccessDataResult<List<Employee>>( employeeDao.findAll(),"listted employee");
	
	}
	@Override
	public Result add(Employee item) {
		employeeDao.save(item);
		return new SuccessResult("added employee");
		
		
	}
	@Override
	public Result delete(Employee item) {
		employeeDao.delete(item);
		return new SuccessResult("deleted employee");
	}


}
