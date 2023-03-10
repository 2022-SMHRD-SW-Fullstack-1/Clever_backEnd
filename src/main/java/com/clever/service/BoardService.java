package com.clever.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.clever.mapper.BoardMapper;
import com.clever.model.Category;
import com.clever.model.Notice;
import com.clever.model.NoticeComment;

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
		fileUpload(notice_info, upload_file);
		return boardMapper.postBoard(notice_info);
	}
	
	
	public List<Notice> getBoardList(int cate_seq){
		return boardMapper.getBoardList(cate_seq);
	}
	
	public int deleteBoard(Notice notice_info) {
		return boardMapper.deleteBoard(notice_info);
	}
	
	public int updateBoard(Notice notice_info,  MultipartFile[] upload_file) {
		fileUpload(notice_info, upload_file);
		return boardMapper.updateBoard(notice_info);
	}
	
	public int postBoardComment(NoticeComment comment_info) {
		return boardMapper.postBoardComment(comment_info);
	}
	
	public List<NoticeComment> getCommentList(int notice_seq){
		return boardMapper.getCommentList(notice_seq);
	}
	

	public void fileUpload(Notice notice_info, MultipartFile[] upload_file) {
		if(upload_file != null) {
			String uploadFolder = "C:\\Users\\smhrd\\Desktop\\Clever_frontEnd\\public\\image";
			
			for(MultipartFile multipartFile : upload_file) {
				System.out.println("Upload File Name : " + multipartFile.getOriginalFilename());
				System.out.println("Upload File Size : " + multipartFile.getSize());
						
				String uploadFileName = multipartFile.getOriginalFilename();
				
				UUID uuid = UUID.randomUUID();
				uploadFileName = uuid + uploadFileName;
	
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
	}
}
