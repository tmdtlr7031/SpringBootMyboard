package nss.myboard.domain.login.service;

import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import nss.myboard.domain.login.domain.context.LoginContext;
import nss.myboard.domain.login.domain.entity.LoginEntity;
import nss.myboard.domain.login.mapper.LoginMapper;

@Service
@RequiredArgsConstructor
public class LoginService implements UserDetailsService {

	private final LoginMapper loginMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LoginEntity userInfo = loginMapper.getLoginUserInfo(username);
		
		if (userInfo == null) {
			throw new InsufficientAuthenticationException("비밀번호가 일치하지 않습니다."); 
		}
		
		return new LoginContext(userInfo, null); // 계층형 권한 적용해보기
	}
}
