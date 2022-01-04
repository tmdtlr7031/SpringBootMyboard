package nss.myboard.domain.login.domain.context;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import nss.myboard.domain.login.domain.entity.LoginEntity;

public class LoginContext extends User{

	private static final long serialVersionUID = 1737562494380941640L;
	
	private final LoginEntity loginEntity;

	public LoginContext(LoginEntity loginEntity, Collection<? extends GrantedAuthority> authorities) {
		super(loginEntity.getUsrId(), loginEntity.getUsrPwd(), authorities);
		this.loginEntity = loginEntity;
	}
	
}
