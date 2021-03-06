package kodlamaio.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="employer_activation_by_employees")
public class EmployerActivationWithEmployee  {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="confirmed_employee_id")
	private int confirmedEmployeeId;
	
	@Column(name="is_confirmed")
	private boolean isConfirmed;
	
	@Column(name="confirmed_date")
	private Date confirmedDate;

}
