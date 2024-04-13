package com.checkTodolist.checkTodolist.web.controller.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.checkTodolist.checkTodolist.service.todo.TodoService;
import com.checkTodolist.checkTodolist.web.controller.dto.CMRespDto;
import com.checkTodolist.checkTodolist.web.controller.dto.CreateTodoReqDto;
import com.checkTodolist.checkTodolist.web.controller.dto.TodoListRespDto;
import com.checkTodolist.checkTodolist.web.controller.dto.UpdateTodoReqDto;

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
					//{type}url 주소에 importance,incomplete,complete가 들어와있어서 3중하나 골라서 추가입력해줘야함
	@GetMapping("/list/{type}")
	public ResponseEntity<?> getTodoList(@PathVariable String type, int page, int contentCount) {
		
		System.out.println(type);
		List<TodoListRespDto> list = null;
		
		try {
			list = todoService.getTodoList(type, page, contentCount);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body(new CMRespDto<>(-1, "실패", list));
		}
		
		return ResponseEntity.ok().body(new CMRespDto<>(1, "성공", list));
	}
	
	@PutMapping("/complete/todo/{todoCode}")
	public ResponseEntity<?> setCompleteTodo(@PathVariable int todoCode) {
		
		boolean status = false;
		
		try {
		status = todoService.updateTodoComplete(todoCode);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body(new CMRespDto<>(-1, "실패",status));
		}
		return ResponseEntity.ok().body(new CMRespDto<>(1, "성공",status));
	}
	
	@PutMapping("/importance/todo/{todoCode}")
public ResponseEntity<?> setImportanceTodo(@PathVariable int todoCode) {
		
		boolean status = false;
		
		try {
		 status = todoService.updateTodoImportance(todoCode);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body(new CMRespDto<>(-1, "실패",status));
		}
		return ResponseEntity.ok().body(new CMRespDto<>(1, "성공",status));
	}
	@PutMapping("/todo/{todoCode}")
	public ResponseEntity<?> setTodo(@PathVariable int todoCode, @RequestBody UpdateTodoReqDto updateTodoReqDto) {
		
		boolean result = false;
		
		try {
			updateTodoReqDto.setTodocode(todoCode);
			result = todoService.updateTodo(updateTodoReqDto);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body(new CMRespDto<>(-1,"실패",result));
		}
		return ResponseEntity.ok().body(new CMRespDto<>(1,"성공",result));
	}
	
	@DeleteMapping("/todo/{todoCode}")
	public ResponseEntity<?> removeTodo(@PathVariable int todoCode) {
		boolean result = false;
		
		try {
			result = todoService.removeTodo(todoCode);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body(new CMRespDto<>(-1,"실패",result));
		}
		return ResponseEntity.ok().body(new CMRespDto<>(1,"성공",result));
	}
	
}
