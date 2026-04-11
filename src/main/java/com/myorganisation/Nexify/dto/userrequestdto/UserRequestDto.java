package com.myorganisation.Nexify.dto.userrequestdto;

import com.myorganisation.Nexify.enums.Gender;
import lombok.Data;

@Data
public class UserRequestDto {
    private String name;
    private String username;
    private String email;
    private Gender gender;
    private String password;
}
