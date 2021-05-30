package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.database.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	

    @Autowired
    public EmployerManager(EmployerDao employerDao) {
        this.employerDao = employerDao;
    }
	
	@Override
	public Result add(Employer item) {
		employerDao.save(item);
		return new SuccessResult();
	}

	@Override
	public Result delete(Employer item) {
		employerDao.delete(item);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(employerDao.findAll());
	}


	
	
	public Result checkEmailIsCompatibleWithDomain(Employer employer){

	       String[] isEmailCompatible = employer.getEmail().split("@", 2); 
	        String webSite = employer.getWebSite().substring(4);

	        if (!isEmailCompatible[1].equals(webSite)){
	            return new ErrorResult("Your Email adress is not compatible with your Web Site domain.");
	        }

	        return new SuccessResult();
	    }



	 
}
