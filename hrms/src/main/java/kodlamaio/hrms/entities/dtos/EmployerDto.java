package kodlamaio.hrms.entities.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerDto extends AuthDto {
	
	private String companyName;
	
	private String webSite;
	
	private String phoneNumber;
	
	private boolean isActivated;
	
	private String passWordConf;
	


}
