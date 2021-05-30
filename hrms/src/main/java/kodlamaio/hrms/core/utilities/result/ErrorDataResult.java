package kodlamaio.hrms.core.utilities.result;

public class ErrorDataResult<TEntity> extends DataResult<TEntity> {

	
	public ErrorDataResult(TEntity data) {
		super(data,false);
		
	}
	public ErrorDataResult(TEntity data ,String message) {
		super(data,false,message);
	}
	public ErrorDataResult(String message) {
		super(false,message);
	}
	public ErrorDataResult() {
		super(false);
	}
	
}
