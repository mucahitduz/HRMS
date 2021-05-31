package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Title;

public interface TitleDao extends JpaRepository<Title,Integer> {

	Title findByTitle(String title);
	
	List<Title> findAllByTitle(String title);
	
}
