package com.mulcam.SpringProject.controller;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mulcam.SpringProject.entity.Board;
import com.mulcam.SpringProject.misc.JSONUtill;
import com.mulcam.SpringProject.service.BoardService;


@Component
@RequestMapping("/file")
public class FileController {
	@Value("${spring.servlet.multipart.location}")
	String uploadDir;
	
	@Autowired
	private BoardService service;
	// 화면 출력
	@GetMapping("/display")
	public ResponseEntity<Resource> display(@RequestParam("fileName") String fileName) {
		String path = "C:\\Temp\\Spring\\";
		String folder = "";
		Resource resource = new FileSystemResource(path + folder + fileName);
		if(!resource.exists()) 
			return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
		HttpHeaders header = new HttpHeaders();
		Path filePath = null;
		try{
			filePath = Paths.get(path + folder + fileName);
			header.add("Content-type", Files.probeContentType(filePath));
		}catch(IOException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Resource>(resource, header, HttpStatus.OK);
	}
	@GetMapping("/thumbnail")
	public ResponseEntity<Resource> jsonParse(@RequestParam("jsonFiles") String jsonFiles_) {
		int bid = Integer.parseInt(jsonFiles_);
		String fileName = "";
		Board board = service.getBoardDetail(bid);
		JSONUtill json = new JSONUtill();
		String jsonFiles = board.getFiles();
		List<String> fileList = new ArrayList<>(); 
		if (jsonFiles != null) {
			fileList = json.parse(jsonFiles);
			fileName = fileList.get(0);
		} else
			fileName = "noimg.png";
		String path = "C:\\Temp\\Spring\\";
		String folder = "";
		Resource resource = new FileSystemResource(path + folder + fileName);
		if(!resource.exists()) 
			return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
		HttpHeaders header = new HttpHeaders();
		Path filePath = null;
		try{
			filePath = Paths.get(path + folder + fileName);
			header.add("Content-type", Files.probeContentType(filePath));
		}catch(IOException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Resource>(resource, header, HttpStatus.OK);
		
	}
}