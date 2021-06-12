package com.udemy.issuemanagement.service;

import com.udemy.issuemanagement.dto.UserDto;
import com.udemy.issuemanagement.util.TPage;
import org.springframework.data.domain.Pageable;

public interface UserService {

    UserDto save(UserDto user);

    UserDto getById(Long id);

    TPage<UserDto> getAllPageable(Pageable pageable);

    UserDto getByUsername(String username);




}
