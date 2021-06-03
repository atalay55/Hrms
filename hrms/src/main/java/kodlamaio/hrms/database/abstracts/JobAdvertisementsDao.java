package kodlamaio.hrms.database.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementsDao extends JpaRepository<JobAdvertisement, Integer> {
	
	List<JobAdvertisement> getByIsActiveTrue();
	List<JobAdvertisement> getByIsActiveTrueAndUser_UserId(int userId);
	List<JobAdvertisement> getByIsActiveTrueOrderByPublishDateDesc();
 	
}
