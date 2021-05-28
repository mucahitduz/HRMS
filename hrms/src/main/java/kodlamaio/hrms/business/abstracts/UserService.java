package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.User;

public interface UserService {

	Result add(User user);
	
	DataResult<List<User>> getAll();
	DataResult<User> getByEmail(String email);

}
