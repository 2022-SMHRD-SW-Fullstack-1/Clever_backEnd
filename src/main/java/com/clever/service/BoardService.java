package com.clever.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.clever.mapper.BoardMapper;
import com.clever.model.Category;
import com.clever.model.Notice;

@Service
public class BoardService {
	@Autowired
	BoardMapper boardMapper;
	
	public int addBoardCategory(Category cate_info) {
		return boardMapper.addBoardCategory(cate_info);
	}
	
	public int countBoardCategory(Category cate_info) {
		return boardMapper.countBoardCategory(cate_info);
	}
	
	public List<Category> getBoardCategory(int group_seq){
		return boardMapper.getBoardCategory(group_seq);
	}
	
	public int postBoard(Notice notice_info, MultipartFile[] upload_file) {
		if(upload_file != null) {
			String uploadFolder = "C:\\Users\\smhrd\\Desktop\\Clever_frontEnd\\public\\image";
			
			for(MultipartFile multipartFile : upload_file) {
				System.out.println("Upload File Name : " + multipartFile.getOriginalFilename());
				System.out.println("Upload File Size : " + multipartFile.getSize());
						
				String uploadFileName = multipartFile.getOriginalFilename();
				
				uploadFileName = notice_info.getNotice_seq() + uploadFileName;
	
				System.out.print("only file name : " + uploadFileName);
				
				notice_info.setNotice_photo(uploadFileName);
				
				File saveFile = new File(uploadFolder, uploadFileName);
			
				try {
					multipartFile.transferTo(saveFile);
				}catch (Exception e) {
					System.out.print(e.getMessage());
				}
			}
		
		}else if(upload_file == null) {
			
			notice_info.setNotice_photo(null);
				
		}
		return boardMapper.postBoard(notice_info);
	}
	
	
	public List<Notice> getBoardList(int cate_seq){
		return boardMapper.getBoardList(cate_seq);
	}
	

}
