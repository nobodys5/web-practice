package com.springboot.web2youngpil20240220.service.board;

import com.springboot.web2youngpil20240220.web.dto.board.CreateBoardReqDto;
import com.springboot.web2youngpil20240220.web.dto.board.CreateBoardRespDto;
import com.springboot.web2youngpil20240220.web.dto.board.ReadBoardRespDto;

public interface BoardService {

	public CreateBoardRespDto createBoard(CreateBoardReqDto boardReqDto) throws Exception;
	
	public ReadBoardRespDto readeBoard(int boardcode) throws Exception;
}
