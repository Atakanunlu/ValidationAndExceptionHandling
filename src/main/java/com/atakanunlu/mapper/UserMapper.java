package com.atakanunlu.mapper;

import com.atakanunlu.dto.UserDto;
import com.atakanunlu.entity.User;
import com.atakanunlu.resource.UserResource;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserDto userDto);
    UserResource toResource(User user);


     List<User> toEntity(List<UserDto> userDto);
     List<UserResource> toResource(List<User> user);

}
