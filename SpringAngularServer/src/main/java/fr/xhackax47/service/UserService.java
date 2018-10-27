package fr.xhackax47.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.xhackax47.dao.UserRepository;
import fr.xhackax47.models.User;

@Service
public class UserService implements UserDetailsService{
	
	private final UserRepository uRepo;
	
	@Autowired
	public UserService(UserRepository uRepo) {
		this.uRepo = uRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Objects.requireNonNull(username);
        User user = uRepo.findUserWithName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return user;
	}

}
