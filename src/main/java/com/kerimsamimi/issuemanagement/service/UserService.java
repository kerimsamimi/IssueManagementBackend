package com.kerimsamimi.issuemanagement.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.kerimsamimi.issuemanagement.entity.User;

public interface UserService {
	
	User save(User user);
	
	User getById(Long id);
	
	Page<User> getAllPageable(Pageable pageable);
	
	User getByUsername(String username);

}
