package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.business.abstracts.PersonnelService;
import kodlamaio.hrms.entities.concretes.Personnel;

@RestController
@RequestMapping("/api/personnel")
public class PersonnelsController {

	private PersonnelService personnelService;
	
	@Autowired
	public PersonnelsController(PersonnelService personnelService) {
		super();
		this.personnelService = personnelService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Personnel>> getAll() {
		return this.personnelService.getAll();
	}
}
