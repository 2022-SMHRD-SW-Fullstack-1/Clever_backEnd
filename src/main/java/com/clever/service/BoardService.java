package com.clever.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clever.mapper.BoardMapper;
import com.clever.model.Category;

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

}
