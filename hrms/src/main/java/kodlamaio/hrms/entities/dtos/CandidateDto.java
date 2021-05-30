package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.Data;

@Data

public class CandidateDto  extends AuthDto{
	
	private String firstName;
	private String lastName;
	private String identityNu;
	private LocalDate dateOfBrith;
	private String passWordConf;

	
}
