package nss.myboard.domain.user.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import nss.myboard.domain.login.domain.entity.LoginEntity;
import nss.myboard.domain.user.domain.dto.UserManageDTO;
import nss.myboard.domain.user.domain.entity.RoleEntity;
import nss.myboard.domain.user.mapper.UserManageMapper;

@Service
@RequiredArgsConstructor
public class UserManageService {
	private final UserManageMapper userManageMapper;
	
	public LoginEntity existsUsers(UserManageDTO userManageDTO) {
		return userManageMapper.existsUsers(userManageDTO);
	}
	
	public int joinUserInfo(UserManageDTO userManageDTO) {
		// 시큐리티를 위해 암호화
		String usrPwd = userManageDTO.getUsrPwd();
		userManageDTO.setUsrPwd(new BCryptPasswordEncoder().encode(usrPwd));
		
		return userManageMapper.joinUser(userManageDTO);
	}
	
	public List<RoleEntity> getRolesInfo() {
		return userManageMapper.getRolesInfo();
	}
}
