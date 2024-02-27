package com.springboot.web2youngpil20240220.domain.board;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Board {
	
	private int boardcode;
	private String title;
	private int usercode;
	private String content;
	private LocalDateTime createdate;
	private LocalDateTime updatedate;
	
}
