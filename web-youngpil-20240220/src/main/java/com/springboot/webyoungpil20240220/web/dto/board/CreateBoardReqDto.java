package com.springboot.webyoungpil20240220.web.dto.board;

import lombok.Data;

@Data
public class CreateBoardReqDto {

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getUsercode() {
		return usercode;
	}

	public void setUsercode(int usercode) {
		this.usercode = usercode;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	private String title;
	private int usercode;
	private String content;
	
	public void showInfo() {
		System.out.println(title);
		System.out.println(usercode);
		System.out.println(content);
		System.out.println("end");
	}
}
