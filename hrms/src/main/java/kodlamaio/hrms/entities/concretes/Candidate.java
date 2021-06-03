package kodlamaio.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="candidates")
public class Candidate extends User {

	@Column(name="first_name")
	private String firstName;
	
	
	@Column(name="last_name")
	private String lastName;
	
	
	@Column(name="identity_number")
	private String identityNu;
	
	
	@Column(name="birth_date")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateOfBrith;
	
	public Candidate(String email, String password, String firstName, String lastName, String nationalId, Date dateOfBirth) {
        super(email, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.identityNu = nationalId;
        this.dateOfBrith = dateOfBirth;
    }

}
