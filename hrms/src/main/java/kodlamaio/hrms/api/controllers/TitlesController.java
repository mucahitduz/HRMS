package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.business.abstracts.TitleService;
import kodlamaio.hrms.entities.concretes.Title;

@RestController
@RequestMapping("/api/titles")
public class TitlesController {
	
	
	private TitleService titleService;
	
	
	@Autowired
	public TitlesController(TitleService titleService) {
		super();
		this.titleService = titleService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody Title title) {
		return this.titleService.add(title);
	}
	
	
	@GetMapping("/getall")
	public DataResult<List<Title>> getAll(){
		return this.titleService.getAll();
	}
}
