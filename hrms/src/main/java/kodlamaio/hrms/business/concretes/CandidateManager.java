package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.database.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;


@Service
public class CandidateManager implements CandidateService{
	
	private CandidateDao candidateDao;
	
	@Autowired
	public  CandidateManager(CandidateDao candidateDao) {
		super();
		this.candidateDao=candidateDao;
		
	}

	@Override
	public Result add(Candidate item) {
		
		candidateDao.save(item);
		return new SuccessResult();
		
	}

	@Override
	public Result delete(Candidate item) {
		candidateDao.delete(item);
		return new SuccessResult();
	}



	@Override
	public DataResult<List<Candidate>>  getAll() {
		
		return new SuccessDataResult<List<Candidate>>(candidateDao.findAll()) ;
	}


}
