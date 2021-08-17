package nss.myboard.domain.login.domain;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Setter
public class LoginEntity {
    /** 시퀀스 */
    private int usrSeq;
    /** 아이디 */
    private String usrId;
    /** 이름 */
    private String usrName;
    /** 비밀번호 */
    private String usrPwd;
    /** 권한설정 */
    private String roleCode;
    /** 사용자 IP정보 */
    private String ip;
    /** 등록일자 */
    private String regDt;
    /** 로그일련번호 */
    private int logSeq;
    /** 로그인시간 */
    private String logDt;
    /** 접속IP일련번호 */
    private int ipSeq;
    /** 로그인실패횟수 */
    private int failCnt;
    /** 업체별 기능 관리 */
    private String companyUseCode;
}
