package nss.myboard.domain.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import nss.myboard.domain.login.domain.entity.LoginEntity;
import nss.myboard.domain.user.domain.dto.UserManageDTO;
import nss.myboard.domain.user.domain.entity.RoleEntity;

@Mapper
public interface UserManageMapper {
	LoginEntity existsUsers(UserManageDTO userManageDTO);
	int joinUser(UserManageDTO userManageDTO);
	List<RoleEntity> getRolesInfo();
}
