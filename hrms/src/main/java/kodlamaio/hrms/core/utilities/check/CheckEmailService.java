package kodlamaio.hrms.core.utilities.check;

public interface CheckEmailService {
	boolean checkwithCode(String code);
	String produceCheckCode();
	boolean checkwithhrms();

}
