package com.springboot.webyoungpil20240220.service;

import com.springboot.webyoungpil20240220.web.dto.board.CreateBoardReqDto;

public interface BoardService {

	public boolean createBoard(CreateBoardReqDto boardReqDto) throws Exception;
}
