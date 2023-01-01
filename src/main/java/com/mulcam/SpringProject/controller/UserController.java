package com.mulcam.SpringProject.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mulcam.SpringProject.entity.User;
import com.mulcam.SpringProject.service.UserService;
import com.mulcam.SpringProject.session.UserSession;


@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserSession userSession;
	
	@Autowired
	private UserService service;
	

	//=================================== 회원 리스트(관리자 전용) ===========================================	
	@RequestMapping("/list/{isDeleted}")
	public String list(@PathVariable String isDeleted, Model model) {
		String uid = userSession.getUid();
		System.out.println(uid);
		if ((uid !=null) && (uid.equals("admin"))) {
			if (isDeleted.equals("1")) {
				List<User> list = service.getWithdrawList(isDeleted);
				model.addAttribute("userList", list);
				return "user/list";
			}
			else {
				List<User> list = service.getList();
				model.addAttribute("userList", list);
				return "user/list";
			}
		}
		else 
			return "redirect:/board/list";

	}
	
	//=================================== 로그인, 로그아웃 ===========================================	
	@GetMapping("/login")
	public String loginform() {
		return "user/login";
	}
	
	@PostMapping("/login")
	public String login(HttpServletRequest req, Model model, HttpSession session) {
		String uid = req.getParameter("uid").strip();
		String pwd = req.getParameter("pwd").strip();
		int result = service.login(uid,pwd);
		switch (result) {
		case UserService.CORRECT_LOGIN :
			session.setAttribute("sessionUid", uid);
			session.setAttribute("sessionUname", userSession.getUname());
			return "redirect:/board/list";
		case UserService.WRONG_PASSWORD :
			return "user/login";
		case UserService.UID_NOT_EXIST :
			return "redirect:/user/register";
		default:
			return "";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/board/list";
	}
	
	//=================================== 회원가입, 수정 ===========================================	
	@GetMapping("/register")
	public String registerForm() {
		
		return "user/register";
	}
	
	
	@PostMapping("/register")
	public String register(HttpServletRequest req, Model model) {
		String uid = req.getParameter("uid").strip();
		String pwd = req.getParameter("pwd").strip();
		String pwd2 = req.getParameter("pwd2").strip();
		String uname = req.getParameter("uname").strip();
		String email = req.getParameter("email").strip();
		String addr = req.getParameter("addr").strip();
		String phoneNum = req.getParameter("phoneNum").strip();
		User user = service.getUser(uid);
		
		if (user != null) {
			model.addAttribute("msg", "중복 아이디입니다.");
			model.addAttribute("url", "/user/register");
			return "user/alertMsg";
		}
		if(pwd.equals(pwd2)) {
			user = new User(uid, pwd, uname, email, addr, phoneNum);
			service.register(user);
			return "redirect:/board/list";
		} else {
			model.addAttribute("msg", "패스워드 입력이 잘못되었습니다.");
			model.addAttribute("url", "/user/register");
			return "user/alertMsg";
		}
	}
	
	
	//=================================== 회원탈퇴신청, 회원삭제(관리자 전용) ===========================================	
	@GetMapping("/update/{uid}")
	public String updateForm(@PathVariable String uid, Model model) {
		User user = service.getUser(uid);
		model.addAttribute("user", user);
		return "user/update";
	}
	
	@PostMapping("/update")
	public String update(HttpServletRequest req, HttpSession session, Model model) {
		String uid = req.getParameter("uid").strip();
		String pwd = req.getParameter("pwd").strip();
		String pwd2 = req.getParameter("pwd2").strip();
		String addr = req.getParameter("addr").strip();
		String phoneNum = req.getParameter("phoneNum").strip();
		String uname = req.getParameter("uname").strip();
		String email = req.getParameter("email").strip();
		
		if (pwd == null || pwd.equals("")) {	// 패스워드를 입력하지 않은 경우
			model.addAttribute("msg", "패스워드를 입력하지 않았습니다.");
			model.addAttribute("url", "/user/update/" + uid);
			return "user/alertMsg";			
		} else if (pwd.equals(pwd2)) {			// 패스워드가 올바른 경우
			User u = new User(pwd, uname, email, addr, phoneNum);
			service.updateUser(u);
			return "redirect:/board/list";
		} else {								// 패스워드를 잘못 입력한 경우
			model.addAttribute("msg", "패스워드 입력이 잘못되었습니다.");
			model.addAttribute("url", "/user/update/" + uid);
			return "user/alertMsg";
		}
		
	}
	
	@GetMapping("/delete/{uid}")
	public String delete(@PathVariable String uid) {
		service.deleteUser(uid);
		return "redirect:/user/list";
	}
	
	@PostMapping("/withdraw")
	public String withdraw(HttpServletRequest req, HttpSession session, Model model) {
		String uid = req.getParameter("uid").strip();
		String pwd = req.getParameter("pwd").strip();
		
		int result = service.withdrawConfirm(uid,pwd);
		switch (result) {
		case UserService.CORRECT_LOGIN :
			service.withdraw(uid);
			return "redirect:/user/logout";
		case UserService.WRONG_PASSWORD :
			model.addAttribute("msg", "패스워드 입력이 잘못되었습니다.");
			model.addAttribute("url", "/user/update/" + uid);
			return "user/alertMsg";
		default:
			return "";
		}
	}
}
