package com.yedam.app.user.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.user.service.UserService;
import com.yedam.app.user.service.UserVO;

@Controller
public class UserController {

	    @Autowired
	    private UserService userService;

	    @GetMapping("/login")
	    public String loginPage() {
	        return "subscription/login";
	    }

	    @PostMapping("/login")
	    public String login(@RequestParam String username, @RequestParam String password, HttpSession session, Model model) {
	        UserVO user = userService.findByUsername(username);
	        if (user != null && user.getPassword().equals(password)) {
	            session.setAttribute("user", user);
	            return "redirect:/subscription";
	        } else {
	            model.addAttribute("error", "Invalid username or password");
	            return "subscription//login";
	        }
	    }

	    @GetMapping("/register")
	    public String registerPage() {
	        return "subscription/register";
	    }

	    @PostMapping("/register")
	    @ResponseBody
	    public String register(UserVO userVO, Model model) {
	        if (userService.findByUsername(userVO.getUsername()) != null) {
	            model.addAttribute("error", "Username already exists");
	            return "subscription/register";
	        }

	        userService.createUser(userVO);

	        return "redirect:/login";
	    }

	    @GetMapping("/logout")
	    public String logout(HttpSession session) {
	        session.invalidate();
	        return "redirect:/login";
	    }
	}

