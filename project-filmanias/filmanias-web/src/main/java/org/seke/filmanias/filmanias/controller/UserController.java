package org.seke.filmanias.filmanias.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.seke.filmanias.filmanias.controller.validation.UserValidator;
import org.seke.filmanias.filmanias.domain.Role;
import org.seke.filmanias.filmanias.domain.User;
import org.seke.filmanias.filmanias.exception.UserNotFoundException;
import org.seke.filmanias.filmanias.model.UserCommand;
import org.seke.filmanias.filmanias.serviceapi.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user/add")
	public ModelAndView openAddNewUserPage() {
		return new ModelAndView("/user/add", "newUser", new UserCommand());
	}

	@InitBinder(value = { "user", "newUser" })
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new UserValidator());
	}

	@RequestMapping(value = "/user/add", params = "saveNewUser", method = RequestMethod.POST)
	public String saveNewUser(@Valid @ModelAttribute("newUser") UserCommand command, BindingResult result) {
		if (result.hasErrors()) {
			return "/user/add";
		}

		User newUser = new User();
		newUser.setUsername(command.getUsername());
		newUser.setPassword(command.getPassword());
		newUser.setAccountNonExpired(command.isAccountNonExpired());
		newUser.setAccountNonLocked(command.isAccountNonLocked());
		newUser.setEmailAdress(command.getEmail());
		newUser.setCredentialsNonExpired(command.isCredentialsNonExpired());
		newUser.setEnabled(command.isEnabled());

		getUserService().saveUser(null, newUser);
		return "redirect:/index.jsp";
	}

	@RequestMapping(value = "/user/viewUsers", method = RequestMethod.GET)
	public ModelAndView viewUsers() {
		List<User> users = getUserService().retrieveAllUsers(null);
		ModelAndView mav = new ModelAndView("/user/viewUsers", "users", users);
		return mav;
	}

	@RequestMapping(value = "/user/edit", method = RequestMethod.GET, params = "username")
	public ModelAndView loadEditUserPage(@RequestParam("username") String username, HttpSession httpSession) {
		User userToEdit = getUserService().retrieveUser(null, username);

		UserCommand user = new UserCommand();
		user.setId(userToEdit.getId());
		user.setUsername(userToEdit.getUsername());
		httpSession.setAttribute("password", userToEdit.getPassword());
		user.setEmail(userToEdit.getEmailAdress());
		user.setAccountNonExpired(userToEdit.isCredentialsNonExpired());
		user.setAccountNonLocked(userToEdit.isAccountNonLocked());
		user.setCredentialsNonExpired(userToEdit.isCredentialsNonExpired());
		user.setEnabled(userToEdit.isEnabled());

		if (userToEdit.getRole() != null) {
			if (userToEdit.getRole().toString().equals("member"))
				user.setMember(true);
			if (userToEdit.getRole().toString().equals("admin")) {
				user.setMember(true);
				user.setAdmin(true);
			}
		}
		return new ModelAndView("/user/edit", "user", user);
	}

	@RequestMapping(value = "/user/edit", params = "updateUser", method = RequestMethod.POST)
	public String updateUser(@Valid UserCommand command, BindingResult result, HttpSession httpSession) throws UserNotFoundException {
		if (result.hasErrors()) {
			return "/user/edit";
		}

		User user = getUserService().retrieveUser(null,command.getId());
		user.setPassword(httpSession.getAttribute("password").toString());
		httpSession.removeAttribute("password");
		user.setAccountNonExpired(command.isAccountNonExpired());
		user.setAccountNonLocked(command.isAccountNonLocked());
		user.setEmailAdress(command.getEmail());
		user.setCredentialsNonExpired(command.isCredentialsNonExpired());
		user.setEnabled(command.isEnabled());

		if(command.isMember()) 
			user.setRole(Role.member);
		
		if(command.isAdmin()) 
			user.setRole(Role.admin);
		
		getUserService().updateUser(null, user);
		return "redirect:/index.jsp";
	}

	@RequestMapping(value = "/user/deleteUser", method = RequestMethod.GET, params = "username")
	public ModelAndView loadDeleteUserPage(@RequestParam("username") String username) {
		User userToDelete = getUserService().retrieveUser(null, username);
		UserCommand command = new UserCommand();
		command.setUsername(userToDelete.getUsername());
		return new ModelAndView("/user/deleteUser", "user", command);
	}

	@RequestMapping(value = "/user/deleteUser", method = RequestMethod.POST, params = "delete")
	public String deleteUser(@RequestParam("username") String username) {
		getUserService().deleteUser(null, username);
		return "redirect:/user/viewUsers";
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
