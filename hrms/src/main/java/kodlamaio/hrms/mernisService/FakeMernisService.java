package kodlamaio.hrms.mernisService;

import org.springframework.stereotype.Service;

@Service
public class FakeMernisService {

	public boolean ValidateByPersonelInfo(long identityNumber, String firstName, String lastName, int dateOfBirth) {
		
		System.out.println(firstName + " " + lastName + " bilgileri geçerli." );
		return true;
	}
}
