package kodlamaio.hrms.core.utilities.validation;

import org.springframework.stereotype.Service;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.entities.dtos.CandidateDto;
import kodlamaio.hrms.entities.dtos.EmployerDto;

@Service
public class Validation {	
	
	
	public static Result checkPasswordConfirmForEmployer(String password, String passwordConfirm){

	    if (!password.equals(passwordConfirm)){
	        return new ErrorResult("Passwords do not match.");
	    }

	    return new SuccessResult();
	}
	

	public static Result checkFields(EmployerDto employerDto){
	        if(employerDto.getWebSite().equals(null)){
	            return new ErrorResult("Field Web Site cannot be blank.");
	        }

	        if(employerDto.getCompanyName().equals(null)){
	            return new ErrorResult("Field Company Name cannot be blank.");
	        }

	        if(employerDto.getEmail().equals(null)){
	            return new ErrorResult("Field Email cannot be blank.");
	        }

	        if(employerDto.getPhoneNumber().equals(null) ){
	            return new ErrorResult("Field Phone Number cannot be blank.");
	        }

	        return new SuccessResult();
	    }
	
	
	
	
	public static Result checkEmailAndPassWordIsEmpty(CandidateDto candidateDto) {
		if(candidateDto.getEmail().isEmpty()) {
			return new ErrorResult("Fields cannot be blank ");
		}
		return new SuccessResult();
		}
	
	
	
	
	public static  Result checkPasswordConfirmForCandidate(String password, String passwordConfirm){

	    if (!password.equals(passwordConfirm)){
	        return new ErrorResult("Passwords do not match.");
	    }

	    return new SuccessResult();
		}

}
