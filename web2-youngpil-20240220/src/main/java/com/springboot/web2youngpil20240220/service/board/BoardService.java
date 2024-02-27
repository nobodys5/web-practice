package com.springboot.web2youngpil20240220.service.board;

import com.springboot.web2youngpil20240220.web.dto.board.CreateBoardReqDto;

public interface BoardService {

	public boolean createBoard(CreateBoardReqDto boardReqDto) throws Exception;
	
}
