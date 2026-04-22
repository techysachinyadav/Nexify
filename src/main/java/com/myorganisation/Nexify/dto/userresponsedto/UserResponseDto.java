package com.myorganisation.Nexify.dto.userresponsedto;

import com.myorganisation.Nexify.entity.MetaData;
import com.myorganisation.Nexify.entity.Profile;
import com.myorganisation.Nexify.enums.Gender;
import lombok.Data;

@Data
public class UserResponseDto {
    private Long id;
    private String name;
    private String username;
    private String email;
    private Gender gender;
    private Profile profile;
    private MetaData metadata;

}
