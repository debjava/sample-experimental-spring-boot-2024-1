package com.ddlab.rnd.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class AppError {
	
	private String errMessage;
	private String info;
	private String code;

}
