package com.gmail.iikaliada.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubscriptionRequestDto {

    @Schema(name = "id", example = "1", implementation = Long.class)
    private Long id;
    @Schema(name = "userId", example = "1", implementation = Long.class)
    private Long userId;

}
