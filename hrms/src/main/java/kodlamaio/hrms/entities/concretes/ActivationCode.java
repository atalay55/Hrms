package kodlamaio.hrms.entities.concretes;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@AllArgsConstructor
@Table(name="activation_codes")
public class ActivationCode {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="activation_code")
	private String activationCode;
	
	
	@Column(name="is_confirmed")
	private boolean isConfirmed;
	
	
	
	


	public ActivationCode(String activationCode, boolean isConfirmed) {
		super();
		this.activationCode = activationCode;
		this.isConfirmed = isConfirmed;
	
	}
	

	

}
