package com.todolist0305.todolist0305.web.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TodoListRespDto {

	private int contentCode;
	private String content;
	private String userName;
	
}
