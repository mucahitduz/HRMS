package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{

	List<JobAdvertisement> getAllByIsActive(boolean isActive);
	
	@Query("From JobAdvertisement where isActive = true Order By createdAt Desc")
	List<JobAdvertisement> getAllByIsAcviteOrderByPostedDateDesc(boolean isActive);
	
	@Query("From JobAdvertisement where isActive = true and employer_id =:employerId")
	List<JobAdvertisement> getAllJobAdvertisementsByEmployer(int employerId);
		
}
