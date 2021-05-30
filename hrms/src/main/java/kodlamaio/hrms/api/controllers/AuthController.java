package kodlamaio.hrms.api.controllers;



import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.dtos.CandidateDto;
import kodlamaio.hrms.entities.dtos.EmployerDto;


@RestController
@RequestMapping("/api/auths")
public class AuthController {
	
	private AuthService authService;
	
	public AuthController(AuthService authService) {
		this.authService=authService;
	}

	@PostMapping("/registercandidate")
	public Result register(CandidateDto candidateDto) {
		return this.authService.addCandidate(candidateDto);
	}
	@PostMapping("/registeremployer")
	public Result register(EmployerDto employerDto) {
		return this.authService.registerForEmployer(employerDto);
	}

}
