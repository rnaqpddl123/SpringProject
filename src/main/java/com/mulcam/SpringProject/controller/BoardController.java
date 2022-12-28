package com.mulcam.SpringProject.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mulcam.SpringProject.entity.Board;
import com.mulcam.SpringProject.service.BoardService;
import com.mulcam.SpringProject.session.UserSession;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private UserSession userSession;
	
	@Autowired
	private BoardService service;
	
	@RequestMapping("/list")
	public String list(Model model) {
		List<Board> list = service.getList();
		model.addAttribute("boardList", list);
		model.addAttribute("uid",userSession.getUid());
		return "board/list";
	}
	
	@GetMapping("/write")
	public String writeForm(Model model) {
		model.addAttribute("uid", userSession.getUid());
		return "board/write";
	}
	
	@PostMapping("/write")
	public String write(HttpServletRequest req, Model model) {
		System.out.println("확인용");
		String uid = req.getParameter("uid").strip();
//		String uid = "messi";
		System.out.println(uid);
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String category = req.getParameter("category");
		int price = Integer.parseInt(req.getParameter("price"));
		String state = req.getParameter("state");
		String files = req.getParameter("files");
		
		Board b = new Board(uid, title, content, category, price, state, files);
		service.write(b);
		
		return "redirect:/board/list";
	}
	
	
}
