package kodlamaio.hrms.Core.utilities.adapters;

import org.springframework.stereotype.Service;

@Service
public interface ValidationService {

	boolean validationByMernis(long identityNumber, String firstName, String lastName, int dateOfBirth);
}
