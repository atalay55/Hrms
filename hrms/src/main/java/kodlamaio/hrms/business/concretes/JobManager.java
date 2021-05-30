package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.database.abstracts.JobDao;
import kodlamaio.hrms.entities.concretes.Job;

@Service
public class JobManager implements JobService{

	private JobDao jobDao;
	
	@Autowired
	public JobManager(JobDao jobDao) {
		super();
		this.jobDao = jobDao;
	}


	@Override
	public DataResult<List<Job>>  getAll() {
		return new SuccessDataResult<List<Job>>( this.jobDao.findAll(),"islem basarili");
	}


	@Override
	public Result add(Job item) {
		jobDao.save(item);
		return new SuccessResult("islem basarili");
		
	}


	@Override
	public Result delete(Job item) {
		jobDao.delete(item);
		return new SuccessResult("islem basarili");
		
	}


	


}
