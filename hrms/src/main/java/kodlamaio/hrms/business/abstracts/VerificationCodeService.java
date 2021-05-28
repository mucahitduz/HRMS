package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.VerificationCode;

public interface VerificationCodeService {
	
	Result add(VerificationCode verificationCode);
}
