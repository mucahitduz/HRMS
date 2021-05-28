package kodlamaio.hrms.Core.utilities.adapters;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.mernisService.FakeMernisService;

@Service
public class MernisServiceAdapter implements ValidationService{

	@Override
	public boolean validationByMernis(long identityNumber, String firstName, String lastName, int dateOfBirth) {
FakeMernisService client = new FakeMernisService();
		
		boolean result = true;
		try {
			result = client.ValidateByPersonelInfo(identityNumber, firstName, lastName, dateOfBirth);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
