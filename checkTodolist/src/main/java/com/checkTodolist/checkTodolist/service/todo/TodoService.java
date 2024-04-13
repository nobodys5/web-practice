package com.checkTodolist.checkTodolist.service.todo;

import java.util.List;

import com.checkTodolist.checkTodolist.web.controller.dto.CreateTodoReqDto;
import com.checkTodolist.checkTodolist.web.controller.dto.TodoListRespDto;
import com.checkTodolist.checkTodolist.web.controller.dto.UpdateTodoReqDto;

public interface TodoService {

	boolean createTodo(CreateTodoReqDto createTodoReqDto) throws Exception;

	public List<TodoListRespDto> getTodoList(String type, int page, int contentCount) throws Exception;
	
	public boolean updateTodoComplete(int todoCode) throws Exception;
	public boolean updateTodoImportance(int todoCode) throws Exception;
	
	public boolean updateTodo(UpdateTodoReqDto updateTodoReqDto) throws Exception;
	
	public boolean removeTodo(int todoCode) throws Exception;
}
