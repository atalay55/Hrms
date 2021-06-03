package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorDataResult;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.database.abstracts.EmployerDao;
import kodlamaio.hrms.database.abstracts.JobAdvertisementsDao;
import kodlamaio.hrms.database.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.EmployerDto;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementsDao jobAdvertisementDao;
	private EmployerDao employerDao;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementsDao jobAdvertisementDao,EmployerDao employerDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.employerDao=employerDao;
	}

	@Override
	public Result add(JobAdvertisement item) {
		
		this.jobAdvertisementDao.save(item);
		return new SuccessResult("added post");
	
	}

	@Override
	public Result delete(JobAdvertisement item) {
		this.jobAdvertisementDao.delete(item);
		return new SuccessResult("deleted post");
		
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll());
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveTrue() {

		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActiveTrue());
		
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueAndId(int userId) {
		if(getIsRealEmployer(userId).isSuccess()) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.
				getByIsActiveTrueAndUser_UserId(userId),"firmanın aktif ");
		
		}
		return new ErrorDataResult<List<JobAdvertisement>>("yetkiniz yok");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueOrderByPublishDateDesc() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActiveTrueOrderByPublishDateDesc());
	}
	
	

	@Override
	public Result setPassiveAdvertisement(int advertismentId) {
		JobAdvertisement tample = this.jobAdvertisementDao.findById(advertismentId).orElse(null);
		tample.setActive(false);
		jobAdvertisementDao.save(tample);
		
		
		return new SuccessResult(""); 
		
	}
	
	
	private Result getIsRealEmployer(int employerId){
		for(Employer employer : employerDao.findAll()) {
			if(employer.getUserId() == employerId) {
				return new SuccessResult();
			}
			return new ErrorResult("kullanıcı employer değil");
		}
		return new ErrorResult("bir sorun olustu");
	}


}
