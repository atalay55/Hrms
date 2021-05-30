package kodlamaio.hrms.core.utilities.result;

public class SuccessDataResult<TEntity> extends DataResult<TEntity> {
	
	public SuccessDataResult(TEntity data) {
		super(data,true);
		
	}
	public SuccessDataResult(TEntity data ,String message) {
		super(data,true,message);
	}
	public SuccessDataResult(String message) {
		super(true,message);
	}
	public SuccessDataResult() {
		super(true);
	}
	

}
