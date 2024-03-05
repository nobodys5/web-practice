package com.todolist0305.todolist0305.domain.content;

import java.time.LocalDateTime;

import com.todolist0305.todolist0305.web.dto.TodoListRespDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
//DB에서 넣을값생성하기 위해 Todo 생성 =Entity라고 칭함
public class Todo {

	private int content_code;
	private String content;
	private int user_code;
	private LocalDateTime create_date;
	private LocalDateTime update_date;
	private String user_name;
	
	public TodoListRespDto toTodoListRespDto() {
		return TodoListRespDto.builder()
				.userName(user_name)
				.contentCode(content_code)
				.content(content)
				.build();
	}
	
}
