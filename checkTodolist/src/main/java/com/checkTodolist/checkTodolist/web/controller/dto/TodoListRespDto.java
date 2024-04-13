package com.checkTodolist.checkTodolist.web.controller.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TodoListRespDto {

	
	private int todoCode;
	private String todo;
	private boolean todoComplete;
	private boolean importance;
	private int totalCount;
	private int incomplete_count;
	
	private LocalDateTime createDate;
	private LocalDateTime updateDate;
}
