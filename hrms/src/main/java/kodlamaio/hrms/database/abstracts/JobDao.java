package kodlamaio.hrms.database.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Job;


public interface JobDao extends JpaRepository<Job, Integer>{

}
