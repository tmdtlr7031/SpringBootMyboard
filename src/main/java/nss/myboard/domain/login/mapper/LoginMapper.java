package nss.myboard.domain.login.mapper;

import org.apache.ibatis.annotations.Mapper;

import nss.myboard.domain.login.domain.entity.LoginEntity;

@Mapper
public interface LoginMapper {
	LoginEntity getLoginUserInfo(String userId);
}
