package com.springboot.web2youngpil20240220.service.board;

import com.springboot.web2youngpil20240220.web.dto.board.CreateBoardReqDto;
import com.springboot.web2youngpil20240220.web.dto.board.CreateBoardRespDto;

public interface BoardService {

	public CreateBoardRespDto createBoard(CreateBoardReqDto boardReqDto) throws Exception;
	
}
