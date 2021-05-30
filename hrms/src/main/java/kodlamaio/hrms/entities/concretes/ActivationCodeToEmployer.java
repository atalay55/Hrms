package kodlamaio.hrms.entities.concretes;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name="activation_code_to_employers")
public class ActivationCodeToEmployer extends ActivationCode{
	

	
	@Column(name="employer_id")
	private int employerId;

	public ActivationCodeToEmployer(int employerId) {
		super();
		this.employerId = employerId;
	}

}
