package com.springboot.web2youngpil20240220.web.controller.api.board;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.web2youngpil20240220.service.board.BoardService;
import com.springboot.web2youngpil20240220.web.dto.CMRespDto;
import com.springboot.web2youngpil20240220.web.dto.board.CreateBoardReqDto;
import com.springboot.web2youngpil20240220.web.dto.board.CreateBoardRespDto;
import com.springboot.web2youngpil20240220.web.dto.board.ReadBoardRespDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/board")
@RequiredArgsConstructor
public class BoardController {

	private final BoardService boardService;
//	@PostMapping("/content")
//	public ResponseEntity<?> addBoard(String title) {
//		System.out.println("게시글 작성완료");
//		System.out.println("title:" + title);
//		return new ResponseEntity<>(title + "게시글 작성성공", HttpStatus.OK);
//	}
	
	
	
//	@PostMapping("/nowContent")
//	public ResponseEntity<?> addBoardNow(int usercode, String content, String title2) {
//		System.out.println("title" + title2);
//		System.out.println("usercode" + usercode);
//		System.out.println("content" + content);
//		return ResponseEntity.ok().body("test");
//	
//	}
	
//	@PostMapping("/nowContent")
//	public ResponseEntity<?> addBoardNow(CreateBoardReqDto createBoardReqDto) {
//		createBoardReqDto.showInfo();
//		System.out.println("title" + title2);
//		System.out.println("usercode" + usercode);
//		System.out.println("content" + content);
//		return ResponseEntity.ok().body("test");
//		
//		
//	
//	}
	
	
	@PostMapping("/content")
	public ResponseEntity<?> addBoardNow(@RequestBody CreateBoardReqDto createBoardReqDto) {
		//json으로 받을때는 @RequestBody 붙여줘야함
		
			CreateBoardRespDto createBoardRespDto = null;
		try {
			System.out.println(createBoardReqDto);
			createBoardRespDto = boardService.createBoard(createBoardReqDto);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1,"게시글 등록실패",createBoardRespDto));
		}
		return ResponseEntity.ok().body(new CMRespDto<>(1,"게시글 등록성공", createBoardRespDto));
	}
	
	@GetMapping("/count/{boardcode}")
	public ResponseEntity<?> getBoard(@PathVariable int boardcode) throws Exception {
		//System.out.println("boardcode:" + boardcode);
		ReadBoardRespDto readBoardRespDto = null;
		
		try {
			readBoardRespDto = boardService.readeBoard(boardcode);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body(new CMRespDto<>(-1, "게시글 조회 성공", readBoardRespDto));
		}
		
		return ResponseEntity.ok().body(new CMRespDto<>(1, "게시글 조회 성공", readBoardRespDto));
	}
	
	/*
	 * 페이징처리
	 * @maaping /list 파람으로 page
	 * 1개의 페이지에 1개의 게시글만 보이도록 하는 요청을 작성하시오
	 */
	
	@GetMapping("/list/{page}")
	public ResponseEntity<?> getBoard2(@RequestParam("boardcode") int boardcode) throws Exception {
		ReadBoardRespDto readBoardRespDto = null;
		
		try {
			readBoardRespDto = boardService.readeBoard(boardcode);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body(new CMRespDto<>(-1, "게시글 조회 성공", readBoardRespDto));
		}
		return ResponseEntity.ok().body(new CMRespDto<>(1, "게시글 조회 성공", readBoardRespDto));
	}
}
