package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobadvertisement")
public class JobAdvertisementController {
	
	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService ) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement> > getAll(){
		return jobAdvertisementService.getAll();
	}
	
	@PostMapping("/addadvertisement")
	public void add(@RequestBody JobAdvertisement jobAdvertisement){
		this.jobAdvertisementService.add(jobAdvertisement);
	}
	@PostMapping("/deleteadvertisiment")
	public void delete(@RequestBody JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementService.delete(jobAdvertisement);
	}
	
	@GetMapping("/getallactiveadvertisements")
	public DataResult<List<JobAdvertisement>> findAllByIsActive(boolean isActive){
		return this.jobAdvertisementService.findAllByIsActive(isActive);
	}
	
}