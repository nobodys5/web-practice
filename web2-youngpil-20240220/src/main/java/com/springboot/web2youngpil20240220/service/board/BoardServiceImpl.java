package com.springboot.web2youngpil20240220.service.board;

import org.springframework.stereotype.Service;

import com.springboot.web2youngpil20240220.web.dto.board.CreateBoardReqDto;

@Service
public class BoardServiceImpl implements BoardService{

	@Override
	public boolean createBoard(CreateBoardReqDto boardReqDto) throws Exception {
		return true;
	}

	
}
