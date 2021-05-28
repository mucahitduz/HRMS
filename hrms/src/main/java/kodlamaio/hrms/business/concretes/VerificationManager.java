package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.Core.utilities.adapters.ValidationService;
import kodlamaio.hrms.Core.utilities.results.ErrorResult;
import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.Core.utilities.results.SuccessResult;
import kodlamaio.hrms.Core.verification.VerifyService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.abstracts.VerificationCodeService;
import kodlamaio.hrms.business.abstracts.VerificationService;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.VerificationCode;

@Service
public class VerificationManager implements VerificationService {

	
	private UserService userService;
	private EmployerService employerService;
	private CandidateService canditateService;
	private VerifyService verifyService;
	private ValidationService validationService;
	private VerificationCodeService verificationCodeService;
	
	@Autowired
	public VerificationManager(UserService userService, EmployerService employerService, CandidateService candidateService, VerifyService verifyService, ValidationService validationService, VerificationCodeService verificationCodeService) {
		super();
		this.userService = userService;
		this.employerService = employerService;
		this.canditateService = candidateService;
		this.verifyService = verifyService;
		this.validationService = validationService;
		this.verificationCodeService = verificationCodeService;
	} 
	
	//Employer Kaydı
	@Override
	public Result registerEmployer(Employer employer, String passwordConfirmation) {
		if(!checkForNullInfoForEmployer(employer)) {
			
			return new ErrorResult("Lütfen bütün bilgileri giriniz.");
		}
		
			
		if(!checkIfEmailExists(employer.getEmail())) {
			
			return new ErrorResult(employer.getEmail() + " zaten kayıtlı.");
		}
		
		if(!checkIfSamePasswords(employer.getPassword(), passwordConfirmation )) {
			
			return new ErrorResult("Şifreler uyuşmuyor.");
		}
		
		employerService.add(employer);
		String code = verifyService.sendCode();
		verificationCodeReport(code, employer.getId(), employer.getEmail());
		return new SuccessResult("Başarıyla kayıt oldunuz.");
	}
	
	//Candidate Kaydı
	@Override
	public Result registerCandidate(Candidate candidate, String passwordConfirmation) {
		
		if(checkIfRealPerson(Long.parseLong(candidate.getIdentityNumber()), candidate.getFirstName(), candidate.getLastName(), candidate.getBirthDate().getYear()) == false) {
			return new ErrorResult("Bilgiler doğrulanamadı.");
		}
		
		if(!checkForNullInfoForCandidate(candidate, passwordConfirmation)) {
			return new ErrorResult("Lütfen bütün bilgileri giriniz.");
		}
		
		if(!checkIfIdentityNumberExists(candidate.getIdentityNumber())) {
			return new ErrorResult(candidate.getIdentityNumber() + " zaten kayıtlı.");
		}
		
		if(!checkIfEmailExists(candidate.getEmail())) {
			return new ErrorResult(candidate.getEmail() + " zaten kayıtlı");
		}
		
		canditateService.add(candidate);
		String code = verifyService.sendCode();
		verificationCodeReport(code, candidate.getId(), candidate.getEmail());
		return new SuccessResult("Başarıyla kayıt oldunuz.");
		
	}

	//Employer Kaydı Doğrulaması
	private boolean checkForNullInfoForEmployer(Employer employer) {
		if(employer.getCompanyName() !=null && employer.getEmail() !=null && employer.getPassword() !=null && employer.getPhoneNumber() !=null && employer.getPhoneNumber() !=null) {
			return true;
		}
		return false;
	}
	
	//Candidate Kaydı Doğrulaması
	private boolean checkForNullInfoForCandidate(Candidate candidate, String confirmPassword) {
		if(candidate.getFirstName() !=null && candidate.getLastName() !=null && candidate.getPassword() !=null && candidate.getEmail() !=null && candidate.getIdentityNumber() != null && candidate.getBirthDate() != null && confirmPassword != null) {
			return true;
		}
		return false;
	}
	
	private boolean checkIfIdentityNumberExists(String identityNumber) {
		if(this.canditateService.getCandidateByIdentityNumber(identityNumber).getData() == null) {
			return true;
		}
		return false;
	}
	
	private boolean checkIfRealPerson(long identityNumber, String firstName, String lastName, int dateOfBirth) {
		if(validationService.validationByMernis(identityNumber, firstName, lastName, dateOfBirth)) {
			return true;
		}
		return false;
	}
	
	//Kayıtlı Email Kontrolü
	private boolean checkIfEmailExists(String email) {
		if(this.userService.getByEmail(email).getData() == null) {
			return true;
		}
		return false;
	}
	
	//Kayıt Olurken Girilen Şifrelerin Aynı Olup Olmadığının Kontrolü
	private boolean checkIfSamePasswords(String password, String confirmPassword) {
		if(!password.equals(confirmPassword)) {
			return false;
		}
		return true;
	}
	
	//Doğrulama Kodunun Gönderildiği Uyarısı
	private void verificationCodeReport(String code, int id, String email) {
		VerificationCode verificationCode = new VerificationCode(id, code, false, LocalDate.now());
		this.verificationCodeService.add(verificationCode);
		System.out.println("Doğrulama kodu " + email + " adresine gönderildi.");
	}
}
