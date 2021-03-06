package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.business.abstracts.PersonnelService;
import kodlamaio.hrms.dataAccess.abstracts.PersonnelDao;
import kodlamaio.hrms.entities.concretes.Personnel;

@Service
public class PersonnelManager implements PersonnelService {

	private PersonnelDao personnelDao;
	
	@Autowired
	public PersonnelManager(PersonnelDao personneldao) {
		super();
		this.personnelDao = personnelDao;
	}
	
	@Override
	public DataResult<List<Personnel>> getAll() {
		
		return new SuccessDataResult<List<Personnel>>(this.personnelDao.findAll());
	}

}
