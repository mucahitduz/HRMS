package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {

	Result add(JobAdvertisement JobAdvertisement);
	
	DataResult<List<JobAdvertisement>> getAllByIsActive(boolean isActive);
	
	DataResult<List<JobAdvertisement>> getAllByIsAcviteOrderByPostedDateDesc();
	
	DataResult<List<JobAdvertisement>> getAllJobAdvertisementsByEmployer(int employerId);
	
	DataResult<JobAdvertisement> setJobAdvertisementToDeactive(int id);
	
}
