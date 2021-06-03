package kodlamaio.hrms.entities.concretes;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="employers")
public class Employer  extends User{
	

	@Column(name="company_name")
	private String companyName;
	
	@Column(name="web_address")
	private String webSite;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="is_activated")
	private boolean isActivated;

	public Employer(String email, String password, String companyName, String webSite, String phoneNumber,
			boolean isActivated) {
		super(email, password);
		this.companyName = companyName;
		this.webSite = webSite;
		this.phoneNumber = phoneNumber;
		this.isActivated = isActivated;
	}



}