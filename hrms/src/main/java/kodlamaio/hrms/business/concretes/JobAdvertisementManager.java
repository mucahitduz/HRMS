package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.Core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.Core.utilities.results.SuccessResult;
import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;
	private EmployerDao employerDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, EmployerDao employerDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.employerDao = employerDao;
		}
	
	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İş ilanı eklendi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllByIsActive(boolean isActive) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getAllByIsActive(isActive), "Aktif iş ilanları listelendi");
	}

@Override
	public DataResult<List<JobAdvertisement>> getAllByIsAcviteOrderByPostedDateDesc() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getAllByIsAcviteOrderByPostedDateDesc(true) ,"Listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllJobAdvertisementsByEmployer(int employerId) {
		
		if(!this.employerDao.existsById(employerId)) {
			return new ErrorDataResult<List<JobAdvertisement>>("İşveren bulunamadı");
		}
		
		else {
			return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getAllJobAdvertisementsByEmployer(employerId), "Şirketin tüm ilanları listelendi");
		}
		
	}

	@Override
	public DataResult<JobAdvertisement> setJobAdvertisementToDeactive(int id) {
		if(!this.jobAdvertisementDao.existsById(id)) {
			return new ErrorDataResult<JobAdvertisement>("İş ilanı bulunamadı") ;
		}
		
		JobAdvertisement ref = this.jobAdvertisementDao.getOne(id);
		ref.setActive(false);
		return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.save(ref), "İş ilanı pasif hale getirildi");
		
	}

}
