package com.kerimsamimi.issuemanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kerimsamimi.issuemanagement.dto.UserDto;
import com.kerimsamimi.issuemanagement.entity.User;
import com.kerimsamimi.issuemanagement.repository.UserRepository;
import com.kerimsamimi.issuemanagement.service.impl.UserServiceImpl;
import com.kerimsamimi.issuemanagement.util.ApiPaths;
import com.kerimsamimi.issuemanagement.util.TPage;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(ApiPaths.UserCtrl.CTRL)
@Api(value = ApiPaths.UserCtrl.CTRL, description = "User APIs")
@CrossOrigin
public class UserController {
	
	@Autowired
    private  UserServiceImpl userServiceImpl;

    

    @GetMapping("/pagination")
    @ApiOperation(value = "Get By Pagination Operation", response = UserDto.class)
    public ResponseEntity<TPage<UserDto>> getAllByPagination(Pageable pageable) {
        TPage<UserDto> data = userServiceImpl.getAllPageable(pageable);
        return ResponseEntity.ok(data);
    }

    @GetMapping()
    @ApiOperation(value = "Get All By Operation", response = UserDto.class)
    public ResponseEntity<List<UserDto>> getAll() {
        List<UserDto> data = userServiceImpl.getAll();
        return ResponseEntity.ok(data);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get By Id Operation", response = UserDto.class)
    public ResponseEntity<UserDto> getById(@PathVariable(value = "id", required = true) Long id) {
        UserDto user = userServiceImpl.getById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    @ApiOperation(value = "Create User", response = UserDto.class)
    public ResponseEntity<UserDto> createUser(@Valid  @RequestBody UserDto user) {
        return ResponseEntity.ok(userServiceImpl.save(user));
    }
    
    @DeleteMapping("/{id}")
	@ApiOperation(value="Delete Operation", response = Boolean.class)
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        return ResponseEntity.ok(userServiceImpl.delete(id));
    }
    
//    @PostMapping("/login")
//    public ResponseEntity<Boolean> login(@RequestBody User user){
//    	return ResponseEntity.ok(userServiceImpl.login(user.getUsername(), user.getPassword()));
//    }
    
}