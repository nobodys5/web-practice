package com.todolist0305.todolist0305.web.dto;

import com.todolist0305.todolist0305.domain.content.Todo;

import lombok.Data;

@Data
// 생성순서 3번
public class CreateTodoReqDto {

	private String content;
	private int usercode;
	
	//reqDto의 매개변수를 받고있기때문에 toentity에 매개변수가 필요없다.
	public Todo toEntity() {
		return Todo.builder()
				.content(content)
				.user_code(usercode)
				.build();
	}
}
