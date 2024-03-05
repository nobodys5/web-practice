package com.todolist0305.todolist0305.web.controller.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todolist0305.todolist0305.service.content.TodoService;
import com.todolist0305.todolist0305.web.dto.CMRespDto;
import com.todolist0305.todolist0305.web.dto.CreateTodoReqDto;
import com.todolist0305.todolist0305.web.dto.TodoListRespDto;

import lombok.RequiredArgsConstructor;


// 생성 순서 1번
@RestController
@RequestMapping("/api/v1/todolist")
@RequiredArgsConstructor
public class TodoController {
		//repository 까지 작성이 끝나면 다시 controller로 넘어와서 객체 생성하여 작성
		private final TodoService todoService;
		
	//순서 2번 mapping 과 메소드 생성
	@PostMapping("/content")
	public ResponseEntity<?> addContent(@RequestBody CreateTodoReqDto createTodoReqDto) {
		
		boolean result = false;
		
		//try catch는 객체생성한뒤에 작성
		try {
			result = todoService.createTodo(createTodoReqDto);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body(new CMRespDto<>(-1, "작성 실패", result));
		}
		return ResponseEntity.ok().body(new CMRespDto<>(1, "작성 성공", result));
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> getTodoList(int page) {
		
		List<TodoListRespDto> todoDtoList = null;
		System.out.println("page: " + page);
		try {
			todoDtoList = todoService.getTodoList(page);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body(new CMRespDto<>(-1,"조회 실패", todoDtoList));
		}
		
		return ResponseEntity.ok().body(new CMRespDto<>(1,"조회 성공", todoDtoList));
	}
}
