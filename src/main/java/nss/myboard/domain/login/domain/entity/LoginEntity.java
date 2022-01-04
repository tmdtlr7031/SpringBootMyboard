package nss.myboard.domain.login.domain.entity;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LoginEntity {
    private int usrSeq;
    private String usrId;
    private String usrName;
    private String usrPwd;
    private String roleSeq;
    private int failCnt;
    private LocalDateTime regDt;
    private String logDt;
    private LocalDateTime updDt;
}
