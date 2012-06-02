package org.seke.filmanias.filmanias.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.seke.filmanias.filmanias.controller.validation.RegistrationValidator;
import org.seke.filmanias.filmanias.domain.User;
import org.seke.filmanias.filmanias.model.RegistrationCommand;
import org.seke.filmanias.filmanias.serviceapi.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistrationController {

	@Autowired
	private UserService userService;

	@InitBinder(value = { "newUser" })
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new RegistrationValidator());
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String openRegisterPage(@ModelAttribute("newUser") RegistrationCommand newUser) {
		return "/register";
	}

	@RequestMapping(value = "/register", params = "saveNewUser", method = RequestMethod.POST)
	public String registerNewUser(@Valid @ModelAttribute("newUser") RegistrationCommand newUser, BindingResult result, HttpSession httpSession) {
		if (result.hasErrors()) {
			return "/register";
		}
		
		User user = new User();
		user.setUsername(newUser.getUsername());
		user.setPassword(newUser.getPassword());
		user.setEmailAdress(newUser.getEmail());
		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
		user.setCredentialsNonExpired(true);
		user.setEnabled(false);
		getUserService().saveUser(null, user);
		
		httpSession.setAttribute("message", "Uspesno ste se registrovali. Mocicete da se ulogujete kad admin omoguci to na vasem account=u.");

		return "redirect:/";
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}