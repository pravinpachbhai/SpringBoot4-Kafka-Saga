package com.pravin.dashboard.service;

import com.pravin.dashboard.dto.UserRequest;
import com.pravin.dashboard.dto.UserResponse;
import com.pravin.dashboard.entity.User;
import com.pravin.dashboard.exception.ResourceNotFoundException;
import com.pravin.dashboard.component.DataMapper;
import com.pravin.dashboard.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final DataMapper dataMapper;
    public UserService(UserRepository userRepository, DataMapper dataMapper) {
        this.userRepository = userRepository;
        this.dataMapper = dataMapper;
    }

    public UserResponse create(UserRequest request) {
        User user = dataMapper.toEntity(request);
        return dataMapper.toResponse(userRepository.save(user));
    }

    public UserResponse getById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        return dataMapper.toResponse(user);
    }

    public List<UserResponse> getAll() {
        return userRepository.findAll()
                .stream()
                .map(dataMapper::toResponse)
                .toList();
    }
}