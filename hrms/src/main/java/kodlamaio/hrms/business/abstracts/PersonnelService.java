package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Personnel;

public interface PersonnelService {
	
	DataResult<List<Personnel>> getAll();
}
