package in.co.vwits.sms.service;

import java.util.List;
import java.util.Optional;

import in.co.vwits.model.exception.UserNotFoundException;
import in.co.vwits.sms.model.User;
import in.co.vwits.sms.response.LoginResponse;

public interface UserService {
	
	void save(User usr);
	
	void deleteByUserId(int userId);
	
	List<User> findAll();
	
	Optional<User> findByUserId(int userId) throws UserNotFoundException;
	
	LoginResponse loginUser(User user);
	
	LoginResponse signupUser(User newUser);

}
