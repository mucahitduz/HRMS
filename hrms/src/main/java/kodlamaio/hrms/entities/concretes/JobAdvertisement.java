package kodlamaio.hrms.entities.concretes;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_advertisements")
public class JobAdvertisement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	//@Column(name="employer_id")
	//private int employerId;
		
	//@Column(name="job_title_id")
	//private int jobTitleId;
		
	//@Column(name="city_id")
	//private int cityId;
	
	@Column(name = "descriptipn")
	private String description;
	
	@Column(name = "number_of_vacant_positions")
	private int numberOfVacantPosition;
	
	@Column(name = "created_at")
	private LocalDateTime createdAt;
	
	@Column(name = "is_active")
	private boolean isActive;
	
	@Column(name = "is_deleted")
	private boolean isDeleted;
	
	@Column(name = "min_salary")
	private int minSalary;
	
	@Column(name = "max_salary")
	private int maxSalary;
	
	@Column(name = "application_deadline")
	private LocalDateTime applicationDeadline;
	
	@ManyToOne
	@JoinColumn(name = "employer_id")
	private Employer employer;
	
	@ManyToOne
	@JoinColumn(name = "title_id")
	private Title title;
	
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;
	
}
