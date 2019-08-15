package com.kerimsamimi.issuemanagement.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.kerimsamimi.issuemanagement.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsername(String username);
	User findByPassword(String password);
	User findByUsernameAndPassword(String username, String password);
}
