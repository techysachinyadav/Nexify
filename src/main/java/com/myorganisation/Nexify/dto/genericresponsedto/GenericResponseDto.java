package com.myorganisation.Nexify.dto.genericresponsedto;

import lombok.Data;

@Data
public class GenericResponseDto {
    private Boolean success;
    private String message;
    private Object details;
}
