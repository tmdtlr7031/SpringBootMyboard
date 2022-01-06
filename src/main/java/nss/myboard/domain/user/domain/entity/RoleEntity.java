package nss.myboard.domain.user.domain.entity;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RoleEntity {
	private int roleSeq;
	private String roleCode;
	private String roleName;
	private String parentCode;
	private String regId;
	private LocalDateTime regDt;
	private String updId;
	private LocalDateTime updDt;
}
