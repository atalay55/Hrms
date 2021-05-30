package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.dtos.CandidateDto;
import kodlamaio.hrms.entities.dtos.EmployerDto;

public interface AuthService {
	
	Result addCandidate(CandidateDto candidateDto);
	Result registerForEmployer(EmployerDto employerDto);

}
