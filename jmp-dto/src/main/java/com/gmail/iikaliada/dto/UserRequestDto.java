package com.gmail.iikaliada.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {

    @Schema(name = "id", example = "1", implementation = Long.class)
    private Long id;
    @Schema(name = "name", example = "John", implementation = String.class)
    private String name;
    @Schema(name = "surname", example = "Doe", implementation = String.class)
    private String surname;
    @Schema(name = "birthday", example = "2000-01-01", implementation = String.class)
    private String birthday;

}
