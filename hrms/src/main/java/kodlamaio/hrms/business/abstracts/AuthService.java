package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.dtos.CandidateDto;
import kodlamaio.hrms.entities.dtos.EmployerDto;


public interface AuthService {
	
	Result addCandidate(CandidateDto candidatedto);
	Result registerForEmployer(EmployerDto employerdto);

}
