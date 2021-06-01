package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.entities.concretes.Candidate;


	@RestController
	@RequestMapping("/api/candidates")
	public class CandidateController {
		
		private CandidateService candidateService;

		@Autowired
		public CandidateController(CandidateService candidateService) {
			super();
			this.candidateService = candidateService;
		}
		
		@GetMapping("/getall")
		public DataResult<List<Candidate> > getAll(){
			return candidateService.getAll();
		}
		
		@PostMapping("/addcandidate")
		public void add(@RequestBody Candidate candidate){
			candidateService.add(candidate);
		}
		@PostMapping("/deletecandidate")
		public void delete(@RequestBody Candidate candidate) {
			candidateService.delete(candidate);
		}
		
	}

