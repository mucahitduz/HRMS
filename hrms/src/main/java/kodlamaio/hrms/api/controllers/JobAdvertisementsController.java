package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobadvertisements")
public class JobAdvertisementsController {

	private JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
		
	@GetMapping("/getAllByIsActive")
	public DataResult<List<JobAdvertisement>>getAllByIsActive(@RequestParam boolean isActive) {
		return this.jobAdvertisementService.getAllByIsActive(isActive);
	}
	
	@GetMapping("/getAllActiveByOrder")
	public DataResult<List<JobAdvertisement>>getAllByIsAcviteOrderByPostedDateDesc(boolean isActive) {
		return this.jobAdvertisementService.getAllByIsAcviteOrderByPostedDateDesc();
	}
	
	@GetMapping("/getEmployersActiveJobAdvertisement")
	public DataResult<List<JobAdvertisement>>getAllJobAdvertisementsByEmployer(int employerId) {
		return this.jobAdvertisementService.getAllJobAdvertisementsByEmployer(employerId);
	}
	
	@PostMapping("/setJobAdvertisementToDeactive")
	public DataResult<JobAdvertisement>setJobAdvertisementToDeactive(int id) {
		return this.jobAdvertisementService.setJobAdvertisementToDeactive(id);
	}
	
}
