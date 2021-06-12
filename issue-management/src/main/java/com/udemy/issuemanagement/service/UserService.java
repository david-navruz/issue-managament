package com.udemy.issuemanagement.service;

import com.udemy.issuemanagement.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    UserDto save(UserDto user);

    UserDto getById(Long id);

    Page<UserDto> getAllPageable(Pageable pageable);

    UserDto getByUsername(String username);




}
