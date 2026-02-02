package br.com.gradle;

import br.com.gradle.dto.UserDTO;
import br.com.gradle.mapper.IUserMAPPER;
import br.com.gradle.model.UserMODEL;

import java.time.LocalDate;

import org.mapstruct.factory.Mappers;

public class Main {

    private static final IUserMAPPER mapper = Mappers.getMapper(IUserMAPPER.class);
    public static void main(String[] args) {
        
        UserMODEL model = new UserMODEL();
        model.setUserName("Mario");
        model.setCode(1);
        model.setBirthDay(LocalDate.now().minusYears(30));
        System.out.println(mapper.toDto(model));

        UserDTO dto = new UserDTO();
        dto.setName("Ana");
        dto.setId(2);
        dto.setBrithDay(LocalDate.now().minusYears(40));
        System.out.println(mapper.toModel(dto));
    }
}