package kodlamaio.hrms.database.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer>{

}
