package kodlamaio.hrms.entities.dtos;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateDto  extends AuthDto{
	
	private String firstName;
	private String lastName;
	private String identityNu;
	private Date dateOfBrith;
	private String passWordConf;

	
}
