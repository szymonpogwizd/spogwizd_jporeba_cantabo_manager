package pl.cantabo.database.user;

import lombok.Data;

@Data
public class UserInfoDTO {

    private String name;

    private String type;

    private String email;

    private Boolean active;
}
