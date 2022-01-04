package nss.myboard.domain.user.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserManageDTO {
    private String usrName;
    private String usrPwd;
    private String roleSeq;
}
