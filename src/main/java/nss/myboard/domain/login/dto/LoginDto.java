package nss.myboard.domain.login.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class LoginDto {

    @NotEmpty
    private String usrId;

    @NotEmpty
    private String usrPwd;
}
