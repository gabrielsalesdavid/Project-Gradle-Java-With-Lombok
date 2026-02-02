package br.com.gradle.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.gradle.model.UserMODEL;
import br.com.gradle.model.UserDTO;

@Mapper
public class IUserMAPPER {

    @Mapping(target = "code", source = "id")
    @Mapping(target = "userName", source = "name")
    UserMODEL toModel(final UserDTO dto);

    @Mapping(target = "id", source = "code")
    @Mapping(target = "name", source = "userName")
    UserMODEL toDto(final UserMODEL model);
}