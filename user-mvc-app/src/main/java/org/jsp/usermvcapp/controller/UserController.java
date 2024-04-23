package org.jsp.usermvcapp.controller;

import org.jsp.usermvcapp.dao.UserDao;
import org.jsp.usermvcapp.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	@Autowired
	private UserDao userDao;

	@RequestMapping(value = "/open-register")
	public ModelAndView openRegister(ModelAndView modelAndView) {
		modelAndView.setViewName("register");
		modelAndView.addObject("user", new User());
		return modelAndView;
	}

	@ResponseBody
//	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@PostMapping(value = "/register")
	public String saveUser(@ModelAttribute(name = "user") User user) {
		user = userDao.saveUser(user);
		return "User saved with Id:" + user.getId();
	}

//	@RequestMapping(value = "/open-view", method = RequestMethod.GET)
	@GetMapping("/open-view")
	public String openView(@RequestParam String view) {
		return view;
	}

	@GetMapping("/find-by-id")
	public ModelAndView findById(@RequestParam(name = "id") int id, ModelAndView modelAndView) {
		User user = userDao.findById(id);
		if (user != null) {
			modelAndView.setViewName("display");
			modelAndView.addObject("user", user);
			return modelAndView;
		}
		modelAndView.setViewName("error");
		modelAndView.addObject("message", "Invalid User Id");
		return modelAndView;
	}

	@PostMapping("/verify-by-phone")
	public ModelAndView verify(@RequestParam long phone, @RequestParam String password, ModelAndView modelAndView) {
		User user = userDao.verify(phone, password);
		if (user != null) {
			modelAndView.setViewName("display");
			modelAndView.addObject("user", user);
			return modelAndView;
		}
		modelAndView.setViewName("error");
		modelAndView.addObject("message", "Invalid Phone Number or Password");
		return modelAndView;
	}

	@PostMapping("/verify-by-email")
	public ModelAndView verify(@RequestParam String email, @RequestParam String password, ModelAndView modelAndView) {
		User user = userDao.verify(email, password);
		if (user != null) {
			modelAndView.setViewName("display");
			modelAndView.addObject("user", user);
			return modelAndView;
		}
		modelAndView.setViewName("error");
		modelAndView.addObject("message", "Invalid Email Id or Password");
		return modelAndView;
	}

	@PostMapping("/verify-by-id")
	public ModelAndView verify(@RequestParam int id, @RequestParam String password, ModelAndView modelAndView) {
		User user = userDao.verify(id, password);
		if (user != null) {
			modelAndView.setViewName("display");
			modelAndView.addObject("user", user);
			return modelAndView;
		}
		modelAndView.setViewName("error");
		modelAndView.addObject("message", "Invalid User Id or Password");
		return modelAndView;
	}

	@GetMapping("/open-update")
	public ModelAndView openUpdate(ModelAndView modelAndView) {
		modelAndView.setViewName("update");
		modelAndView.addObject("user", new User());
		return modelAndView;
	}

	@PostMapping("/update")
	public ModelAndView updateUser(@ModelAttribute(name = "user") User user, ModelAndView modelAndView) {
		modelAndView.setViewName("error");
		user = userDao.updateUser(user);
		if (user != null) {
			modelAndView.addObject("message", "user updated");
			return modelAndView;
		}
		modelAndView.addObject("message", "Cannot Update User as Id is Invalid");
		return modelAndView;
	}

	@RequestMapping("/delete")
	public ModelAndView delete(@RequestParam int id, ModelAndView modelAndView) {
		modelAndView.setViewName("error");
		boolean deleted = userDao.deleteUser(id);
		if (deleted) {
			modelAndView.addObject("message", "user deleted");
			return modelAndView;
		}
		modelAndView.addObject("message", "Cannot delete User as Id is Invalid");
		return modelAndView;
	}
}
