package com.springboot.web2youngpil20240220.web.dto.board;

import com.springboot.web2youngpil20240220.domain.board.Board;

import lombok.Data;

@Data
public class CreateBoardReqDto {

	private String title;
	private int usercode;
	private String content;
	
	public Board toEntity() {
		
		return Board.builder()
				.title(title)
				.usercode(usercode)
				.content(content)
				.build();
	}
	/*
	 * 리턴 Board
	 * 메소드명 toEntity
	 * title,usercode,content를 board 객체안에
	 * 넣어서 리턴 
	 */

	public void showInfo() {
		System.out.println(title);
		System.out.println(usercode);
		System.out.println(content);
		System.out.println("end");
	}
	
}
