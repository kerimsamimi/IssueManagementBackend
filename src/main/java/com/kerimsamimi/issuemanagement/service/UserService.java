package com.kerimsamimi.issuemanagement.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.kerimsamimi.issuemanagement.dto.UserDto;
import com.kerimsamimi.issuemanagement.util.TPage;

public interface UserService {
	
	public UserDto save(UserDto user);
	
	public UserDto getById(Long id);
	
	public TPage<UserDto> getAllPageable(Pageable pageable);
	
	public UserDto getByUsername(String username);
	
	public List<UserDto> getAll();

}
