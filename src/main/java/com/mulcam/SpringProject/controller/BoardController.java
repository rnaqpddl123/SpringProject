package com.mulcam.SpringProject.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	
	// 게시판 리스트
	@RequestMapping("/list")
	public String list(HttpServletRequest req,Model model, HttpSession session) {
		int currentBoardPage = (req.getParameter("p")==null || req.getParameter("p")=="") ? 1 : Integer.parseInt(req.getParameter("p"));
		String field = (req.getParameter("f")==null || req.getParameter("f")=="") ? "b.title" : req.getParameter("f");
		String query = "%" +  ((req.getParameter("q")==null || req.getParameter("q")=="") ? "" : req.getParameter("q")) + "%";
		String state = "%" + ((req.getParameter("state")==null || req.getParameter("state")=="") ? "" : req.getParameter("state")) + "%";
		String category ="%" +  ((req.getParameter("category")==null || req.getParameter("category")=="") ? "" : req.getParameter("category")) + "%";
		int offset = (currentBoardPage-1)*10;
		List<Board> list = service.getList(field, query, state, category, offset);
		
		// pagenation
		int totalBoardNum = service.getBoardCount(field, query);
		int totalPages = (int)Math.ceil(totalBoardNum/10.);
		int startPage = (int)Math.ceil((currentBoardPage-0.5)/10. -1 )*10 +1;
		int endPage = Math.min(totalPages, startPage+9);
		List<String> pageList = new ArrayList<>();
		for (int i=startPage; i<=endPage; i++)
			pageList.add(String.valueOf(i));
		model.addAttribute("pageList", pageList);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("totalPages", totalPages);
		
		String today = LocalDate.now().toString();
		model.addAttribute("today", today);
		System.out.println("현재날짜" + today);
		System.out.println(list.get(0).getModTime());
		System.out.println(list.get(1).getModTime());
		System.out.println(list.get(2).getModTime());
//		for (Board a : list) {
//			System.out.println(a.getModTime());
//		}
		
		model.addAttribute("boardList", list);
		session.setAttribute("currentBoardPage", currentBoardPage);
//		model.addAttribute("currentBoardPage", page);
//		model.addAttribute("uid",userSession.getUid());
		return "board/list";
	}
	
	// 게시글 작성
	@GetMapping("/write")
	public String writeForm(Model model) {
		model.addAttribute("uid", userSession.getUid());
		return "board/write";
	}
	@PostMapping("/write")
	public String write(HttpServletRequest req, Model model) {
		String uid = req.getParameter("uid").strip();
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
	
	// 게시글보기
	@GetMapping("/detail")
	public String detail(HttpServletRequest req, Model model) {
		int bid = Integer.parseInt((String)req.getParameter("bid"));
		String uid = req.getParameter("uid");
		if (req.getParameter("option")==null && (!uid.equals(userSession.getUid()))) 
			service.increaseViewCount(bid);
		
		Board board = service.getBoardDetail(bid);
		
		model.addAttribute("board", board);
		model.addAttribute("uid",userSession.getUid());
		return "board/detail";
	}
	
	
	@PostMapping("/upload")
	public String upload(@RequestParam("uploadfile") MultipartFile uploadfile, Model model) {
		
		List<Board> list = new ArrayList<>();
		
		
		return null;
	}
	
	
}
