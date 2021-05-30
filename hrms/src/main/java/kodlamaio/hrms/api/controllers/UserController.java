package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.entities.concretes.User;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	UserService userService;

	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<User> > getAll(){
		return userService.getAll();
	}
	
	
	@PostMapping("/add")
	public void add(User user) {
		userService.add(user);
	}
	@PostMapping("/delete")
	public void delete(User user) {
		userService.delete(user);
	}

		


}
