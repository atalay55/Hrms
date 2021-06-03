package kodlamaio.hrms.database.abstracts;



import org.springframework.data.jpa.repository.JpaRepository;

import com.google.common.base.Optional;

import kodlamaio.hrms.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer>{
	Optional<User> getByEmail(String email);
	

}
