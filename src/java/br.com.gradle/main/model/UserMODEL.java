package br.com.gradle.model;

import java.time.LocalDate;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Data
public class UserMODEL {
    
    private int code;
    private String userName;
    private LocalDate birthDay;
}