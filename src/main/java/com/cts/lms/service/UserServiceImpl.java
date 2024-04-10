package com.cts.lms.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.cts.lms.dto.RegisterDto;
import com.cts.lms.entity.User;
import com.cts.lms.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	
	private ModelMapper modelMapper;

	public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
	}



	@Override
	public RegisterDto registerUser(RegisterDto registerDto) {
		
	User user = modelMapper.map(registerDto, User.class);
	
	User registeredUser = userRepository.save(user);
	
	
		return modelMapper.map(registeredUser, RegisterDto.class);
	}

}
