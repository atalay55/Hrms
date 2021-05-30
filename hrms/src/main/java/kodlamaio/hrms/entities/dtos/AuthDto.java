package kodlamaio.hrms.entities.dtos;

import lombok.Data;

@Data
public abstract class AuthDto {
	private String email;
	private String passWord;

}
