package in.co.vwits.sms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import in.co.vwits.sms.model.User;

@Repository
public interface UserRepository extends JpaRepository <User, Integer> {
	
	
	User findByUserName(String username);
	
	@Query("SELECT u FROM User u WHERE u.userName = :username AND u.password = :password")
	Optional<User> findOneByUsernameAndPassword(String username, String password);

}
