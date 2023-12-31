package in.co.vwits.sms.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.co.vwits.model.exception.UserNotFoundException;
import in.co.vwits.sms.model.User;
import in.co.vwits.sms.response.LoginResponse;
import in.co.vwits.sms.service.UserService;

@RestController
@RequestMapping(value="/api/user")
public class UserRestController {

	@Autowired
	private UserService service;

	@GetMapping
	public List<User> findAll(){
		return service.findAll();
	}

	@PostMapping("/signup")
	public User createNewUser(@RequestBody User user) {
		this.service.save(user);
		return user;
	}

	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable int userId) {
		try {
			Optional<User> user = service.findByUserId(userId);
			return ResponseEntity.ok(user.orElse(null));
		} catch (UserNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping(value="/{userId}")
	public void deleteUserByUserId(@PathVariable int userId) {
		this.service.deleteByUserId(userId);
	}


	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody User user) {
		LoginResponse loginResponse = service.loginUser(user);
		return ResponseEntity.ok(loginResponse);
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<User> updateUserProfile(@PathVariable int userId, @RequestBody User updatedUser) throws UserNotFoundException {
			Optional<User> existingUser = service.findByUserId(userId);
			if (existingUser.isPresent()) {
				User userToUpdate = existingUser.get();
				userToUpdate.setUsername(updatedUser.getUsername());
				userToUpdate.setPassword(updatedUser.getPassword());
				service.save(userToUpdate);
				return ResponseEntity.ok(userToUpdate);	
			}
			 else {
		            throw new UserNotFoundException();
		        }
	
	}
	
	




}
