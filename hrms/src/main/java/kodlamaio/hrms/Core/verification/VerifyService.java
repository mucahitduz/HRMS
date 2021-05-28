package kodlamaio.hrms.Core.verification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface VerifyService {

	@Autowired
	void send(String email);
	String sendCode();
}
