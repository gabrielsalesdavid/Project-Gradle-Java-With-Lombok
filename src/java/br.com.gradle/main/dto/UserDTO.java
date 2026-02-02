package br.com.gradle.dto;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Data
public class UserDTO {

    private int id;
    private String name;
    private LocalDate bithDay;
}
