package kodlamaio.hrms.entities.dtos;


import lombok.Data;

@Data
public class EmployerDto extends AuthDto {
	
	private String companyName;
	
	private String webSite;
	
	private String phoneNumber;
	
	private boolean isActivated;
	
	private String passWordConf;
	


}
