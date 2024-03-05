package com.todolist0305.todolist0305.service.content;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.todolist0305.todolist0305.domain.content.Todo;
import com.todolist0305.todolist0305.domain.content.TodoRepository;
import com.todolist0305.todolist0305.web.dto.CreateTodoReqDto;
import com.todolist0305.todolist0305.web.dto.TodoListRespDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

	//repository 로 던지기위해 객체생성
	private final TodoRepository todoRepository;
	
	@Override
	public boolean createTodo(CreateTodoReqDto createTodoReqDto) throws Exception {
		Todo todoEntity = createTodoReqDto.toEntity();
		
//		for(int i = 0; i < 100; i++) {
//			todoEntity = Todo.builder()
//					.content("게시글게시글" + (i + 1))
//					.user_code(1)
//					.build();
//		}
		return todoRepository.save(todoEntity) > 0; 
	}

	@Override
	public List<TodoListRespDto> getTodoList(int page) throws Exception {
		
		List<TodoListRespDto> todoDtoList = new ArrayList<TodoListRespDto>();
		
		todoRepository.getTodoListOfIndex((page - 1) * 10).forEach(todo -> {
			todoDtoList.add(todo.toTodoListRespDto());
		});
		return todoDtoList;
	}

}
