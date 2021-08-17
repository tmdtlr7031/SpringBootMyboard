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
    public String loginForm(Model model, @SessionAttribute(name = "loginUserId", required = false ) LoginDto loginDto) {
        // 로그인 된 사용자인 경우 메인 페이지로
        if (loginDto != null) {
            return "redirect:/dashboard/selectDashBoardList.do";
        }
        model.addAttribute("users", new LoginDto());
        return "index";
    }

    @PostMapping("/actionLogin")
    public String actionLogin(@ModelAttribute("searchVO") @Validated LoginDto loginDto, BindingResult bindingResult
//            , @SessionAttribute(name = "loginUserId", required = false ) LoginDto sessionCheck : 인터셉터로 빼자 <TODO>
            , Model model) {

        return "redirect:/dashboard/selectDashBoardList.do";
    }

    @RequestMapping("/actionLogout")
    public String actionLogout(HttpSession session, @SessionAttribute(name = "loginUserId", required = false ) LoginDto loginDto) {
        // 중복 호출 시 예외 발생 방지
        if (loginDto != null) {
            session.invalidate();
        }
        return "redirect:/";
    }
}
