package kodlamaio.hrms.business.concretes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.adaptor.check.MernisCheckService;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.check.CheckEmailService;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.core.utilities.validation.Validation;
import kodlamaio.hrms.database.abstracts.ActivationCodeDao;
import kodlamaio.hrms.database.abstracts.ActivationCodeForCandidateDao;
import kodlamaio.hrms.database.abstracts.ActivationCodeForEmployer;
import kodlamaio.hrms.entities.concretes.ActivationCode;
import kodlamaio.hrms.entities.concretes.ActivationCodeToCandidate;
import kodlamaio.hrms.entities.concretes.ActivationCodeToEmployer;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.dtos.CandidateDto;
import kodlamaio.hrms.entities.dtos.EmployerDto;
import lombok.var;

@Service
public class AuthManager implements AuthService {

	private UserService userService;
	private MernisCheckService mernischeckService;
	private EmployerService employerService;
	private CandidateService candidateService;
	private CheckEmailService checkEmailService;



	@Autowired
	public AuthManager(CheckEmailService checkEmailService,MernisCheckService mernischeckService,UserService userService,EmployerService employerService,
		CandidateService candidateService) {
		this.mernischeckService=mernischeckService;
		this.userService=userService;
		this.employerService=employerService;
		this.checkEmailService=checkEmailService;
		this.candidateService=candidateService;

	}
	
	
	@Override
	public Result addCandidate(CandidateDto candidateDto) {
		 
		Validation.checkEmailAndPassWordIsEmpty(candidateDto);
		
		 var checkUserEntry =  BusinessRules.run(
				 Validation.checkPasswordConfirmForCandidate(candidateDto.getPassWord(),candidateDto.getPassWordConf()),
		         this.userService.checkUserExitsByEmail(candidateDto.getEmail()));
		 if (!checkUserEntry.isSuccess()){
		        return new ErrorResult(checkUserEntry.getMessage());
		    }
		 
		 if(this.mernischeckService.checkIfRealPerson(candidateDto).isSuccess()) {
		 Candidate candidateInfo = new Candidate(candidateDto.getEmail(),candidateDto.getPassWord(),candidateDto.getFirstName(),
				 candidateDto.getLastName(),candidateDto.getIdentityNu(),
				 candidateDto.getDateOfBrith());

		 	candidateService.add(candidateInfo);
		 	return new SuccessResult("kay??t yap??ld??");
		 }
		
			 
		 return new ErrorResult( "operation failed");
		 
		 
		 
		    

		
	}
						

		@Override
	  public Result registerForEmployer(EmployerDto employerDto) {
			
	        var result = BusinessRules.run(
	        		Validation.checkPasswordConfirmForEmployer(employerDto.getPassWord(), employerDto.getPassWordConf()),
	                Validation.checkFields(employerDto),
	                this.userService.checkUserExitsByEmail(employerDto.getEmail()));

	        if (!result.isSuccess()){
	            return new ErrorResult(result.getMessage());
	        }

	        Employer infoEmployer= new Employer(employerDto.getCompanyName(),employerDto.getWebSite(),employerDto.getPhoneNumber(),false);
	        
	        //String checkCode=checkService.produceCheckCode();
			 
			 
//			 if(this.checkService.checkwithCode(checkCode)) {
//				 ActivationCode code = new ActivationCode(checkCode,true);
//				 ActivationCodeToEmployer employerCode = new ActivationCodeToEmployer(infoEmployer.getId());
//				 this.activationCodeDao.save(code);
//				 this.codeForEmployer.save(employerCode);
//				 infoEmployer.setActivated(true);
//			     this.employerService.add(infoEmployer);
//			     return new SuccessResult("Employer is successfully registered.");
//			 
//			 
//			 }
			 if(true) {
				 
			        this.employerService.add(infoEmployer);
			        return new SuccessResult("Employer is successfully registered.");
			 }
			 
	        
			 return new ErrorResult( "operation failed");
		}


	

	





	
		
}
		
	


