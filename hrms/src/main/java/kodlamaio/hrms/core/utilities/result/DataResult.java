package kodlamaio.hrms.core.utilities.result;

public class DataResult<TEntity> extends Result{
	
	private TEntity data;
	
	public DataResult(){}
	
	public DataResult(boolean success) {
		super(success);
	}
	
	public DataResult(TEntity data,boolean success,String message) {
		super(success,message);
		this.data=data;
		
	}
	public DataResult(TEntity data, boolean success) {
		super(success);
		this.data=data;
	}
	public DataResult(TEntity data) {
		this.data=data;	
	}
	
	public DataResult(boolean success,String message) {
		super(success,message);
	}

	
	public TEntity getData() {
		return this.data;
	}
	
}
