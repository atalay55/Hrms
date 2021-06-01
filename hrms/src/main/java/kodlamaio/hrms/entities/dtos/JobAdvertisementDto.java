package kodlamaio.hrms.entities.dtos;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementDto {

	private String jobName;
	
	
	private String userName;
	
	private int numberOfPosition;

	private Date publishDate;
	

	private Date deadline;
	
	private boolean isActive;
}
