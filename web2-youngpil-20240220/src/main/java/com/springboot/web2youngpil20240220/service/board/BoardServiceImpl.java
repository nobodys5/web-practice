package com.springboot.web2youngpil20240220.service.board;

import org.springframework.stereotype.Service;

import com.springboot.web2youngpil20240220.domain.board.Board;
import com.springboot.web2youngpil20240220.domain.board.BoardRepository;
import com.springboot.web2youngpil20240220.web.dto.board.CreateBoardReqDto;
import com.springboot.web2youngpil20240220.web.dto.board.CreateBoardRespDto;
import com.springboot.web2youngpil20240220.web.dto.board.ReadBoardRespDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

	private final BoardRepository boardRepository;
	
	@Override
	public CreateBoardRespDto createBoard(CreateBoardReqDto boardReqDto) throws Exception {
		
		Board boardEntity = boardReqDto.toEntity();
//		System.out.println("DB가기전:" + boardEntity);
//		int result = boardRepository.save(boardEntity);
//		System.out.println("숫자 result:" + result);
//		System.out.println("DB갔다온 후:" + boardEntity);
		
		boolean insertStatus = boardRepository.save(boardEntity) > 0;
		//System.out.println(boardEntity.toCreateBoardDto(insertStatus));
		return boardEntity.toCreateBoardDto(insertStatus);
	}

	@Override
	public ReadBoardRespDto readeBoard(int boardcode) throws Exception {
		
		return boardRepository.findBoardByBoardcode(boardcode).toReadBoardDto();
	}

	
	
}
