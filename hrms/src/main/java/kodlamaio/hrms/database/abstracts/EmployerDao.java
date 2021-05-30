package kodlamaio.hrms.database.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sun.xml.bind.v2.model.core.ID;

import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, ID> {

}
