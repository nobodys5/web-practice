package com.checkTodolist.checkTodolist.web.controller.dto;

import java.util.HashMap;
import java.util.Map;

import com.checkTodolist.checkTodolist.domain.todo.Todo;

import lombok.Data;

@Data
public class CreateTodoReqDto {

	private boolean importance;
	private String todo;
	
	public Todo toEntity() {
	return Todo.builder()
		.importance_flag(importance ? 1: 0)
		.todo_content(todo)
		.build();
	}
	
	Map<String, Integer> addmap = new HashMap<String, Integer>();
	
	
}
