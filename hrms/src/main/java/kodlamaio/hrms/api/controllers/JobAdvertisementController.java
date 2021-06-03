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
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobadvertisement")
public class JobAdvertisementController {
	
	JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService ) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement> > getAll(){
		return this.jobAdvertisementService.getAll();
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
	public DataResult<List<JobAdvertisement>> findAllByIsActive( ){
		return this.jobAdvertisementService.getByIsActiveTrue();
	}
	
	@GetMapping("/getallactiveadvertisementbyemployer")
	public DataResult<List<JobAdvertisement>> findAllByIsActiveAndEmployerId(int userId){
		return this.jobAdvertisementService.getByIsActiveTrueAndId(userId);
	}
	
	@GetMapping("/getallactiveadvertisementdesc")
	public DataResult<List<JobAdvertisement>> findAllByIsActiveOrderByPublishDateDesc(){
		return this.jobAdvertisementService.getByIsActiveTrueOrderByPublishDateDesc();
	}
	
	@PostMapping("/setPassiveAdvertisiment")
	public Result setPassiveAdvertisement(int advertismentId) {
		return this.jobAdvertisementService.setPassiveAdvertisement(advertismentId);
	}
	
}