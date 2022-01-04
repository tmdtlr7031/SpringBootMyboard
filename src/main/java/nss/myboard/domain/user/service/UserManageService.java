package nss.myboard.domain.user.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import nss.myboard.domain.login.domain.entity.LoginEntity;
import nss.myboard.domain.user.domain.dto.UserManageDTO;
import nss.myboard.domain.user.mapper.UserManageMapper;

@Service
@RequiredArgsConstructor
public class UserManageService {
	private final UserManageMapper userManageMapper;
	
	public LoginEntity existsUsers(UserManageDTO userManageDTO) {
		return userManageMapper.existsUsers(userManageDTO);
	}
	
	public int joinUserInfo(UserManageDTO userManageDTO) {
		return userManageMapper.joinUser(userManageDTO);
	}
}
