package kodlamaio.hrms.core.utilities.check;

import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.database.abstracts.ActivationCodeDao;

@Service
public class CheckEmailManager implements CheckEmailService {

	Random random ;
	ActivationCodeDao activationCode;
	
	private int High =5000;
	private int Low =1000;
	
	@Autowired
	public CheckEmailManager(ActivationCodeDao activationCode) {
		
		this.activationCode=activationCode;
	}
	
	
	@Override
	public boolean checkwithCode(String code) {
		if(code.equals( produceCheckCode())) {
			return true;
		}
		return false;
	}

	@Override
	public String produceCheckCode() {
		int result= random.nextInt(High-Low)+Low;
		String resultt = String.valueOf(result);
		System.out.println(resultt);
		// emaile loglanma kodu bulunacak
		return resultt;
	}


	@Override
	public boolean checkwithhrms() {
		
		return true;
		
	}
	
}
	
