package kodlamaio.hrms.database.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.google.common.base.Optional;
import com.sun.xml.bind.v2.model.core.ID;

import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, ID> {
	
}
