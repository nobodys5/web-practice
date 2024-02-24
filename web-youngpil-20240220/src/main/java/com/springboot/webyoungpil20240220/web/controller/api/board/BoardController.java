package com.springboot.webyoungpil20240220.web.controller.api.board;

import org.apache.catalina.connector.Response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.webyoungpil20240220.service.BoardService;
import com.springboot.webyoungpil20240220.web.dto.board.CreateBoardReqDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/board")
@RequiredArgsConstructor
public class BoardController {

	private final BoardService boardService;
	
//	@PostMapping("/nowContent")
//	public ResponseEntity<?> addBoardNow(String title, int usercode, String content) {
//		System.out.println("title:"+title);
//		System.out.println("usercode:"+1);
//		System.out.println("content:"+content);
//		return ResponseEntity.ok().body("test");
//	}
	
//	@PostMapping("/nowContent")
//	public ResponseEntity<?> addBoardNow(CreateBoardReqDto createBoardReqDto) {
//
//		createBoardReqDto.showInfo();
//		createBoardReqDto.setContent("content");
////		System.out.println("title:"+ title);
////		System.out.println("usercode:"+1);
////		System.out.println("content:"+content);
//		return ResponseEntity.ok().body("test");
//	}
	
	@PostMapping("/content")
	public ResponseEntity<?> addBoard(@RequestBody CreateBoardReqDto createBoardReqDto) {
		// json으로 받을때는 @RequestBody 붙여줘야함.
		boolean responseData = false;	
	
	try {
		System.out.println(createBoardReqDto);
		responseData = boardService.createBoard(createBoardReqDto);
	} catch (Exception e) {
		e.printStackTrace();
		return ResponseEntity.internalServerError().body(responseData);
	}
	return ResponseEntity.ok().body(responseData);
	}
	
	
	@PostMapping("/nowContent")
	public ResponseEntity<?> addBoardNow(CreateBoardReqDto createBoardReqDto) {

		// 불리언 변수 초기화
		boolean responseData = false;
		
		try {//try에서 아래와같은 코드가 터지면
		responseData = boardService.createBoard(createBoardReqDto);
		} catch (Exception e) {
			//catch이부분에서 예외처리를해준다.
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(responseData);
		}
		
		return ResponseEntity.ok().body(responseData);
	}
}
