package nss.myboard.domain.login;

import lombok.extern.slf4j.Slf4j;
import nss.myboard.domain.login.dto.LoginDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class LoginController {

    @GetMapping("/")
    public String loginForm(Model model) {
        model.addAttribute("users", new LoginDto());
        return "index";
    }
}
