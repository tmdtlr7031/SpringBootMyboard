package nss.myboard.domain.login;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import lombok.extern.slf4j.Slf4j;
import nss.myboard.domain.login.domain.dto.LoginDto;

@Controller
@Slf4j
public class LoginController {

    @GetMapping("/")
    public String skipIndex(Model model) {
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

        session.setAttribute("loginUser", loginDto);
        return "redirect:/dashboard/selectDashBoardList";
    }

    /**
     * 로그아웃 처리
     */
    @RequestMapping("/actionLogout")
    public String actionLogout(HttpSession session, @SessionAttribute(name = "loginUser", required = false ) LoginDto loginDto) {
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
