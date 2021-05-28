package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employer;

public interface VerificationService {

	Result registerEmployer(Employer employer, String passwordConfirmation);
	Result registerCandidate(Candidate candidate, String passwordConfirmation);
}
