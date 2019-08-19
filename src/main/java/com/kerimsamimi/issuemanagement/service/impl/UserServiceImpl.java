package com.kerimsamimi.issuemanagement.service.impl;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kerimsamimi.issuemanagement.dto.UserDto;
import com.kerimsamimi.issuemanagement.entity.User;
import com.kerimsamimi.issuemanagement.repository.UserRepository;
import com.kerimsamimi.issuemanagement.service.UserService;
import com.kerimsamimi.issuemanagement.util.TPage;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
	
	@Autowired
    private ModelMapper modelMapper;

	@Autowired
	private UserRepository userRepository;
	
	@Override
    public UserDto save(UserDto user) {
        User u = modelMapper.map(user, User.class);
        u = userRepository.save(u);
        user.setId(u.getId());
        return user;
    }
	
	@Override
	public User saveUser(User user) {
		User u = userRepository.save(user);
//		  user.setId(u.getId());
	        return u;
	}

	@Override
    public UserDto getById(Long id) {
        User u = userRepository.getOne(id);
        return modelMapper.map(u, UserDto.class);
    }

	@Override
    public TPage<UserDto> getAllPageable(Pageable pageable) {
        Page<User> data = userRepository.findAll(pageable);
        TPage<UserDto> respnose = new TPage<UserDto>();
        respnose.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), UserDto[].class)));
        return respnose;
    }
	
	public List<UserDto> getAll() {
        List<User> data = userRepository.findAll();
        return Arrays.asList(modelMapper.map(data, UserDto[].class));
    }

	@Override
    public UserDto getByUsername(String username) {
        User u = userRepository.findByUsername(username);
        return modelMapper.map(u, UserDto.class);
    }

	@Override
	public Boolean delete(Long id) {
		userRepository.deleteById(id);
		return true;
	}

	@Override
	public Boolean login(String username, String password) {
		User user = userRepository.findByUsernameAndPassword(username, password);
		return user!=null;
	}

	@Override
	public Boolean register(String username, String password, String passwordConfirm) {
//		User user = new User();
//		if(user.getPassword()!=null && user.getPassword()==user.getPasswordConfirm() && user.getUsername()!=null) {
//	        return userRepository.saveByUsernameAndPasswordAndPasswordConfirm(user.getUsername(),user.getPassword(),user.getPasswordConfirm());
//	      }
		return false;
	}
}
