package com.escax.crud.mapper;

import com.escax.crud.dto.UserDTO;
import com.escax.crud.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toDTO(User user);
    User toEntity(UserDTO userDTO);

}
