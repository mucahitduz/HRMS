package kodlamaio.hrms.Core.verification;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class VerifyManager implements VerifyService {

	@Override
	public void send(String email) {
		UUID uuid = UUID.randomUUID();
		String verificationLink = "https://hrmsverification/" + uuid.toString();
		System.out.println("Doğrulama linki  " + email + " adresine gönderildi." );
		System.out.println("Doğrulama için linke tıklayınız :  " + verificationLink );
		
	}

	@Override
	public String sendCode() {
		UUID uuid = UUID.randomUUID();
		String verificationCode = uuid.toString();
		System.out.println("Doğrulama kodunuz :  " + verificationCode );
		return verificationCode;
	}

}
