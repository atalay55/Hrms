package kodlamaio.hrms.core.utilities.check;

public interface CheckService {
	boolean checkwithCode(String code);
	String produceCheckCode();
	boolean checkwithhrms();

}
