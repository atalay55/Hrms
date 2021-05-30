package kodlamaio.hrms.database.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.ActivationCodeToCandidate;

public interface ActivationCodeForCandidateDao extends JpaRepository<ActivationCodeToCandidate, Integer>{

}
