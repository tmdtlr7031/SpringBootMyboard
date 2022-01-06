package nss.myboard.domain.user.domain.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserManageDTO {
	
	@NotBlank
	@Pattern(regexp = "^([\\w-]+(?:\\.[\\w-]+)*)@((?:[\\w-]+\\.)*\\w[\\w-]{0,66})\\.([a-z]{2,6}(?:\\.[a-z]{2})?)$")
	private String usrId;
	
	@NotBlank
    private String usrName;
	
	@NotBlank
    private String usrPwd;
	
	@NotBlank
    private String usrPwdChk;
	
	@NotBlank
    private String roleSeq;
}
