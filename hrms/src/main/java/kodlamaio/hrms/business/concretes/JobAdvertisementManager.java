package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorDataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.database.abstracts.JobAdvertisementsDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementsDao jobAdvertisementDao;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementsDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public Result add(JobAdvertisement item) {
		jobAdvertisementDao.save(item);
		return new SuccessResult();
	}

	@Override
	public Result delete(JobAdvertisement item) {
		jobAdvertisementDao.delete(item);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findAll());
	}

	@Override
	public DataResult<List<JobAdvertisement>> findAllByIsActive(boolean isActive) {

	
		
		if(isActive) {
			return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findAllByIsActive(isActive));
		}
		return new ErrorDataResult<List<JobAdvertisement>>("yetkiniz yok");
	}
	

}
