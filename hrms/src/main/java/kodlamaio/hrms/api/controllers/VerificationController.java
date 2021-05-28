package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.business.abstracts.VerificationService;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/verification")
public class VerificationController {

	private VerificationService verificationService;
	
	@Autowired
	public VerificationController(VerificationService verificationService) {
		this.verificationService = verificationService;
	}
	
	@PostMapping("/registerEmployer")
	public Result registerEmployer(@RequestBody Employer employer, String confirmPassword) {
		return verificationService.registerEmployer(employer, confirmPassword);
	}
	
	@PostMapping("/registerCandidate")
	public Result registerCandidate(@RequestBody Candidate candidate, String confirmPassword) {
		return verificationService.registerCandidate(candidate, confirmPassword);
	}
	
}
