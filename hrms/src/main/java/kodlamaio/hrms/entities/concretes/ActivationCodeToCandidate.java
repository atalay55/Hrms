package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@Table(name="activation_code_to_candidates")
public class ActivationCodeToCandidate extends ActivationCode {
	
	
	
	
	@Column(name="candidate_id")
	private int candidateId;

	public ActivationCodeToCandidate(int candidateId) {
		super();
		this.candidateId = candidateId;
	}
	
}