package com.gmail.iikaliada.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {

    @Schema(name = "id", implementation = Long.class)
    private Long id;
    @Schema(name = "name", implementation = String.class)
    private String name;
    @Schema(name = "surname", implementation = String.class)
    private String surname;
    @Schema(name = "birthday", implementation = String.class)
    private String birthday;

}
