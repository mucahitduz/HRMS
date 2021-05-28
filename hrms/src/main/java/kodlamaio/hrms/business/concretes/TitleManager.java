package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.ErrorResult;
import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.Core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.Core.utilities.results.SuccessResult;
import kodlamaio.hrms.business.abstracts.TitleService;
import kodlamaio.hrms.dataAccess.abstracts.TitleDao;
import kodlamaio.hrms.entities.concretes.Title;

@Service
public class TitleManager implements TitleService {

	private TitleDao titleDao;
	
	@Autowired
	public TitleManager(TitleDao titleDao) {
		super();
		this.titleDao = titleDao;
	}
	

	@Override
	public Result add(Title title) {
		if(getTitle(title.getTitle()).getData() != null) {
			return new ErrorResult(title.getTitle() + "zaten kayıtlı.");
		}
		this.titleDao.save(title);
		return new SuccessResult("İş ünvanı eklendi.");
	}



	@Override
	public DataResult<List<Title>> getAll() {
		
		return new SuccessDataResult<List<Title>>(this.titleDao.findAll());
	}



	@Override
	public DataResult<Title> getTitle(String title) {
	
		return new SuccessDataResult<Title>(this.titleDao.findByTitle(title));
	}

}

