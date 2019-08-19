package com.kerimsamimi.issuemanagement.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.kerimsamimi.issuemanagement.dto.UserDto;
import com.kerimsamimi.issuemanagement.entity.User;
import com.kerimsamimi.issuemanagement.util.TPage;

public interface UserService {
	
	public UserDto save(UserDto user);
	
	public User saveUser(User user);
	
	public UserDto getById(Long id);
	
	public TPage<UserDto> getAllPageable(Pageable pageable);
	
	public UserDto getByUsername(String username);
	
	public List<UserDto> getAll();
	
	public Boolean delete(Long id);
	
	public Boolean login(String username, String password);
	
	public Boolean register(String username, String password, String passwordConfirm);

}
