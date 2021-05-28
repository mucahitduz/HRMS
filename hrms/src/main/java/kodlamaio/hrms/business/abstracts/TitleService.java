package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Title;

public interface TitleService {
	Result add(Title title);
	
	DataResult<List<Title>> getAll();
	DataResult<Title> getTitle(String title);
}
