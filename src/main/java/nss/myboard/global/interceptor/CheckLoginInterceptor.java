package nss.myboard.global.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import lombok.extern.slf4j.Slf4j;
import nss.myboard.domain.login.domain.dto.LoginDto;

@Slf4j
public class CheckLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 로그인 안 된 사용자인 경우 메인 페이지로
        HttpSession session = request.getSession(false);

        if (session == null) {
            log.info("로그인 된 이력이 없습니다! 로그인 페이지 이동");
            response.sendRedirect("/loginForm");
            return false;
        }else{
            LoginDto loginDto = (LoginDto) session.getAttribute("loginUser");

            /**
             * <TODO>
             *     - 사용자별 권한에 따라 페이지 이동 분기처리 필요 (주소창에 URL찍고 들어오는 경우 대비)
             *     - 해당 URL을 지원하는지 (@RequestMapping에 있는지 여부 or DB로 관리되는 URL여부 판단)
             *         - 관리되는 URL이면 로그인 후 요청 페이지로 이동
             */
            log.info("User Info : {}", loginDto.getUsrId());
        }

        return true;
    }
}
