package nss.myboard.domain.login.domain.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class LoginDto {

    @NotBlank
    private String usrId;

    @NotBlank
    private String usrPwd;
}
