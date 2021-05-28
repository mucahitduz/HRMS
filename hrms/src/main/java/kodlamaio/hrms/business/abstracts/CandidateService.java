package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateService {
	
	Result add(Candidate candidate);
	
	DataResult<List<Candidate>> getAll();
	DataResult<Candidate> getCandidateByIdentityNumber(String identityNumber);
}
