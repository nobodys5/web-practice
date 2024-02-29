package com.springboot.web2youngpil20240220.web.dto.board;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ReadBoardRespDto {

	private int boardcode;
	private String title;
	private int usercode;
	private String username;
	private String content;
	private LocalDateTime createdate;
}
