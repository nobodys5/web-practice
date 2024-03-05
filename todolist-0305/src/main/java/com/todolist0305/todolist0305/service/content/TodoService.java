package com.todolist0305.todolist0305.service.content;import java.util.List;

import com.todolist0305.todolist0305.web.dto.CreateTodoReqDto;
import com.todolist0305.todolist0305.web.dto.TodoListRespDto;

public interface TodoService {

	public boolean createTodo(CreateTodoReqDto createTodoReqDto) throws Exception;
	public List<TodoListRespDto> getTodoList(int page) throws Exception;
	
}
