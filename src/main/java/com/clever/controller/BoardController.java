package com.clever.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.clever.model.Category;
import com.clever.model.Notice;
import com.clever.service.BoardService;

@RequestMapping("/board")
@RestController
public class BoardController {
	@Autowired
	BoardService boardService;
	
	@PostMapping("/addcategory")
	public int addBoardCategory(@RequestBody Category cate_info) {
		return boardService.addBoardCategory(cate_info);
	}
	
	@PostMapping("/countcategory")
	public int countBoardCategory(@RequestBody Category cate_info) {
		return boardService.countBoardCategory(cate_info);
	}
	
	@PostMapping("/getcategory")
	public List<Category> getBoardCategory(@RequestBody Category cate_info) {	
		List<Category> cateList = boardService.getBoardCategory(cate_info.getGroup_seq());
		return cateList;
	}
	
	@PostMapping("/post")
	public int postBoard(@RequestBody Notice notice_info) {
		return boardService.postBoard(notice_info);
	}
	
	@PostMapping("/list")
	public List<Notice> getBoardList(@RequestBody Notice notice_info){
		List<Notice> boardList = boardService.getBoardList(notice_info.getCate_seq());
		return boardList;
	}
	
	@PostMapping("/file")
	public void uploadFile(@RequestParam(value="inputFile", required=false) MultipartFile[] upload_file) throws Exception {
		String uploadFolder = "/Users/ahae/Desktop/img";
		
		for(MultipartFile multipartFile : upload_file) {
			System.out.print("Upload File Name : " + multipartFile.getOriginalFilename());
			System.out.print("Upload File Size : " + multipartFile.getSize());
					
			String uploadFileName = multipartFile.getOriginalFilename();
			
			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\" ) + 1);
			System.out.print("only file name : " + uploadFileName);
			
			File saveFile = new File(uploadFolder, uploadFileName);
		
			try {
				multipartFile.transferTo(saveFile);
			}catch (Exception e) {
				System.out.print(e.getMessage());
			}
		}

		
	}
	

}
