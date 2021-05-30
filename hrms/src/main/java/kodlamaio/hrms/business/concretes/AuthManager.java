package kodlamaio.hrms.business.concretes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.adaptor.check.MernisCheckService;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.check.CheckService;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
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
	private CheckService checkService;
	private ActivationCodeDao activationCodeDao;
	private ActivationCodeForCandidateDao codeForCandidateDao;
	private ActivationCodeForEmployer codeForEmployer;
	private CandidateService candidateService;
	
	



	@Autowired
	public AuthManager(MernisCheckService mernischeckService,UserService userService,ActivationCodeDao activationCodeDao,EmployerService employerService,
		CheckService checkService,CandidateService candidateService,ActivationCodeForCandidateDao codeForCandidateDao,ActivationCodeForEmployer codeForEmployer) {
		this.mernischeckService=mernischeckService;
		this.userService=userService;
		this.activationCodeDao=activationCodeDao;
		this.employerService=employerService;
		this.checkService=checkService;
		this.candidateService=candidateService;
		this.codeForCandidateDao=codeForCandidateDao;
		this.codeForEmployer=codeForEmployer;
	
	}
	
	
	@Override
	public Result addCandidate(CandidateDto candidateDto) {
		 if (candidateDto.getEmail() ==null || candidateDto.getPassWord() == null || candidateDto.getPassWordConf() == null){
		        return new ErrorResult("Fields cannot be blank ");
		    }
		 
		 var checkUserEntry =  BusinessRules.run(this.checkPasswordConfirm(candidateDto.getPassWord(), candidateDto.getPassWordConf()),
		            this.userService.checkUserExitsByEmail(candidateDto.getEmail()));
		 if (!checkUserEntry.isSuccess()){
		        return new ErrorResult(checkUserEntry.getMessage());
		    }
		 if(this.mernischeckService.checkIfRealPerson(candidateDto).isSuccess()) {
		 Candidate candidateInfo = new Candidate(candidateDto.getEmail(),candidateDto.getPassWord(),candidateDto.getFirstName(),candidateDto.getLastName(),
				 candidateDto.getIdentityNu(),candidateDto.getDateOfBrith());
		 String checkCode=checkService.produceCheckCode();
		 
		 
		 if(this.checkService.checkwithCode(checkCode)) {
			 ActivationCode code = new ActivationCode(checkCode,true);
			 ActivationCodeToCandidate candidatecode = new ActivationCodeToCandidate(candidateInfo.getId());
			 this.activationCodeDao.save(code);
			 this.codeForCandidateDao.save(candidatecode);
			 this.candidateService.add(candidateInfo);
			 
			 return new SuccessResult("Candidate is successfully registered.");}
		 else if(this.checkService.checkwithhrms()) {
			 candidateService.add(candidateInfo);
			 
			 return new SuccessResult("Candidate is successfully registered.");}
		 }
		 
		    

		 return new ErrorResult( "operation failed");
	}
						

		@Override
	  public Result registerForEmployer(EmployerDto employerDto) {
			
	        var result = BusinessRules.run(this.checkPasswordConfirm(employerDto.getPassWord(), employerDto.getPassWordConf()),
	                checkFields(employerDto), this.userService.checkUserExitsByEmail(employerDto.getEmail()));

	        if (!result.isSuccess()){
	            return new ErrorResult(result.getMessage());
	        }

	        Employer infoEmployer= new Employer(employerDto.getCompanyName(),employerDto.getWebSite(),employerDto.getPhoneNumber(),false);
	        
	        String checkCode=checkService.produceCheckCode();
			 
			 
			 if(this.checkService.checkwithCode(checkCode)) {
				 ActivationCode code = new ActivationCode(checkCode,true);
				 ActivationCodeToEmployer employerCode = new ActivationCodeToEmployer(infoEmployer.getId());
				 this.activationCodeDao.save(code);
				 this.codeForEmployer.save(employerCode);
				 infoEmployer.setActivated(true);
			     this.employerService.add(infoEmployer);
			     return new SuccessResult("Employer is successfully registered.");
			 
			 
			 }
			 else if(this.checkService.checkwithhrms()) {
				 
			        this.employerService.add(infoEmployer);
			        return new SuccessResult("Employer is successfully registered.");
			 }
			 
	        
			 return new ErrorResult( "operation failed");
		}

	private Result checkPasswordConfirm(String password, String passwordConfirm){

	    if (!password.equals(passwordConfirm)){
	        return new ErrorResult("Passwords do not match.");
	    }

	    return new SuccessResult();
	}
	
	    
	  private  Result checkFields(EmployerDto employerDto){
	        if(employerDto.getWebSite() == null){
	            return new ErrorResult("Field Web Site cannot be blank.");
	        }

	        if(employerDto.getCompanyName() == null){
	            return new ErrorResult("Field Company Name cannot be blank.");
	        }

	        if(employerDto.getEmail() == null){
	            return new ErrorResult("Field Email cannot be blank.");
	        }

	        if(employerDto.getPhoneNumber() == null){
	            return new ErrorResult("Field Phone Number cannot be blank.");
	        }

	        return new SuccessResult();
	    }
	 
	





	
		
}
		
	


