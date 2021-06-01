package kodlamaio.hrms.core.adaptor.check.mernis;


import java.sql.Date;


import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.adaptor.check.MernisCheckService;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.entities.dtos.CandidateDto;
import lombok.var;


@Service
public class MernisCheckManager implements MernisCheckService {
	  

    @Override
    public Result checkIfRealPerson(CandidateDto candidateDto) {
        var result = BusinessRules.run(checkNationalId(candidateDto.getIdentityNu()),checkFirstName(candidateDto.getFirstName()),
                checkLastName(candidateDto.getLastName()), checkBirthOfDate(candidateDto.getDateOfBrith()));
        if (!result.isSuccess()){
            return new ErrorResult(result.getMessage());
        }
        return new SuccessResult();
    }


    private Result checkNationalId(String nationalId){

        if(nationalId ==null){
            return new ErrorResult("Field National Id cannot be blank ");
        }

        if (nationalId.length() != 11){
            return new ErrorResult("National identity must consist of 11 characters.");
        }

        return new SuccessResult("National Id is validated.");

    }

    private Result checkFirstName(String firstName){

        if(firstName ==null){
            return new ErrorResult("Field First Name cannot be blank ");
        }

        if (firstName.length() <2){
            return new ErrorResult("The First Name must consist of a minimum of 2 characters.");
        }

        return new SuccessResult("First Name is validated.");
    }

    private Result checkLastName(String lastName){

        if(lastName ==null){
            return new ErrorResult("Field Last Name cannot be blank ");
        }

        if (lastName.length() <2){
            return new ErrorResult("The Last Name must consist of a minimum of 2 characters.");
        }

        return new SuccessResult("Last Name is validated.");
    }

    private Result checkBirthOfDate(Date date){

        if(date ==null){
            return new ErrorResult("Field Birth of Date cannot be blank ");
        }


        return new SuccessResult("Birth of date validated.");
    }

}

