package kodlamaio.hrms.database.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer> {
	Candidate getByIdentityNuContaining(String nationalId);
}
