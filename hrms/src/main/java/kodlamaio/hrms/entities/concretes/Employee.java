package kodlamaio.hrms.entities.concretes;



import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@Entity
@AllArgsConstructor
@Table(name="employees")
public class Employee extends User{
	
	

	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	
//	@Column(name="identity_number")
//	private String identityNu;
//	
//	@Column(name="birth_date")
//	private Date dateOfBrith;

	public Employee () {}
}
