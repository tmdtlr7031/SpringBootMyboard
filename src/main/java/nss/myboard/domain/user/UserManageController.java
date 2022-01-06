package nss.myboard.domain.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import nss.myboard.domain.user.domain.dto.UserManageDTO;
import nss.myboard.domain.user.service.UserManageService;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserManageController {
	
	private final UserManageService userManageService;
	
	@GetMapping("/manage")
	public String manage(@ModelAttribute UserManageDTO manageDTO, Model model) {
		model.addAttribute("resultList", userManageService.existsUsers(manageDTO));
		return "user/UserManageList";
	}
	
	@GetMapping("/joinform")
	public String joinForm(@ModelAttribute UserManageDTO userManageDTO, Model model) {
		model.addAttribute("roleList", userManageService.getRolesInfo());
		return "user/UserJoinForm";
	}
	
	@PostMapping(value = "/save")
	public String save(@Validated @ModelAttribute UserManageDTO userManageDTO, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("roleList", userManageService.getRolesInfo());
			return "user/UserJoinForm";
		}
		userManageService.joinUserInfo(userManageDTO);
		return "redirect:/user/manage";
	}
}
