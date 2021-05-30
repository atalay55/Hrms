package kodlamaio.hrms.database.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.ActivationCodeToEmployer;

public interface ActivationCodeForEmployer extends JpaRepository<ActivationCodeToEmployer, Integer> {

}
