package nss.myboard.domain.user.mapper;

import org.apache.ibatis.annotations.Mapper;

import nss.myboard.domain.login.domain.entity.LoginEntity;
import nss.myboard.domain.user.domain.dto.UserManageDTO;

@Mapper
public interface UserManageMapper {
	LoginEntity existsUsers(UserManageDTO userManageDTO);
	int joinUser(UserManageDTO userManageDTO);
}
