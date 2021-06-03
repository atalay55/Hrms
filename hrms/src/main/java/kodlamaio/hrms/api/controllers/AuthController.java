package kodlamaio.hrms.api.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.dtos.CandidateDto;
import kodlamaio.hrms.entities.dtos.EmployerDto;



@RestController
@RequestMapping("/api/auths")
public class AuthController {
	
	private AuthService authService;
	
	@Autowired
	public AuthController(AuthService authService) {
		this.authService=authService;
	}

	@PostMapping("/registercandidate")
	public Result register(@RequestBody CandidateDto candidatedto) {
		return this.authService.addCandidate(candidatedto);
	}
	@PostMapping("/registeremployer")
	public Result register(@RequestBody EmployerDto employerDto) {
		return this.authService.registerForEmployer(employerDto);
	}

}
