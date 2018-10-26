package fr.xhackax47.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.xhackax47.dao.UserRepository;

@RestController
@RequestMapping("/api/livrado")
public class UserController {
	
	@Autowired
	UserRepository uRepo;
	
	@GetMapping("/users")
	public void getAllUser() {
		uRepo.findAll();
	}

}
