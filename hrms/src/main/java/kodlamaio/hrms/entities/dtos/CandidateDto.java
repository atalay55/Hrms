package kodlamaio.hrms.entities.dtos;

import java.sql.Date;


import lombok.Data;

@Data

public class CandidateDto  extends AuthDto{
	
	private String firstName;
	private String lastName;
	private String identityNu;
	private Date dateOfBrith;
	private String passWordConf;

	
}
