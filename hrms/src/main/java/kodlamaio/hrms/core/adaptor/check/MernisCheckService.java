package kodlamaio.hrms.core.adaptor.check;


import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.dtos.CandidateDto;

public interface MernisCheckService {
	Result checkIfRealPerson(CandidateDto candidateDto);

}
