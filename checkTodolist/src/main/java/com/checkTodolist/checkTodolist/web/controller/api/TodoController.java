package com.checkTodolist.checkTodolist.web.controller.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.checkTodolist.checkTodolist.service.todo.TodoService;
import com.checkTodolist.checkTodolist.web.controller.dto.CMRespDto;
import com.checkTodolist.checkTodolist.web.controller.dto.CreateTodoReqDto;
import com.checkTodolist.checkTodolist.web.controller.dto.TodoListRespDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/todolist")
@RequiredArgsConstructor
public class TodoController {

	private final TodoService todoService;
	@PostMapping("/todo")
	public ResponseEntity<?> addContent(@RequestBody CreateTodoReqDto createTodoReqDto) {
		boolean result = false;
		
		try {
		result = todoService.createTodo(createTodoReqDto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.ok().body(new CMRespDto<>(-1, "실패", result));
		}
		
		return ResponseEntity.ok().body(new CMRespDto<>(1, "성공", result));
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> getTodoList(@RequestParam int page, int contentCount) {
		
		List<TodoListRespDto> list = null;
		
		try {
			list = todoService.getTodoList(page, contentCount);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body(new CMRespDto<>(-1, "실패", list));
		}
		
		return ResponseEntity.ok().body(new CMRespDto<>(1, "성공", list));
	}
	
	
	
}
