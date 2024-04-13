package com.checkTodolist.checkTodolist.web.controller.dto;

import com.checkTodolist.checkTodolist.domain.todo.Todo;

import lombok.Data;

@Data
public class UpdateTodoReqDto {

	private int todocode;
	private String todo;
	
	public Todo toEntity() {
		return Todo.builder()
				.todo_code(todocode)
				.todo_content(todo)
				.build();
	}
}
