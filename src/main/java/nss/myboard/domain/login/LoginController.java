package nss.myboard.domain.login;

import lombok.extern.slf4j.Slf4j;
import nss.myboard.domain.login.dto.LoginDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class LoginController {

    /* @SessionAttribute를 이용한 세션 확인 */
    @GetMapping("/")
    public String skipIndex(Model model) {
        // 로그인 된 사용자인 경우 메인 페이지로 <TODO> 인터셉터로 뺄 것
        // @SessionAttribute(name = "loginUserId", required = false ) LoginDto loginDto
//        if (loginDto != null) {
//            return "redirect:/dashboard/selectDashBoardList.do";
//        }
        return "redirect:/loginForm";
    }

    /**
     * 로그인 폼
     */
    @GetMapping("/loginForm")
    public String loginForm(@ModelAttribute("loginDto") LoginDto loginDto) {
        return "login/loginForm";
    }

    /**
     * 로그인 처리
     */
    @PostMapping("/actionLogin")
    public String actionLogin(@Validated @ModelAttribute("loginDto") LoginDto loginDto, BindingResult bindingResult,
                              HttpSession session, Model model) {

        // 객체 에러 (있으면 여기 넣어야함)

        if (bindingResult.hasErrors()) {
            log.info("error = {}", bindingResult);
            return "login/loginForm";
        }

        session.setAttribute("loginUserId", loginDto.getUsrId());
        return "redirect:/dashboard/selectDashBoardList.do";
    }

    /**
     * 로그아웃 처리
     */
    @RequestMapping("/actionLogout")
    public String actionLogout(HttpSession session, @SessionAttribute(name = "loginUserId", required = false ) LoginDto loginDto) {
        // 중복 호출 시 예외 발생 방지
        if (loginDto != null) {
            session.invalidate();
        }
        return "redirect:/loginForm";
    }

    /**
     * 세션 수동 연장
     */
    @ResponseBody
    @GetMapping(value = "/keepSession.do")
    public void sessionContinue(HttpSession session){
        session.setMaxInactiveInterval(30*60); // 초단위, 30분 동안 세션 유효시간 설정
    }
}
