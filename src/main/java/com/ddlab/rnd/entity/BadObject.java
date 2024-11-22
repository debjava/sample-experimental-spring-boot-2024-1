package com.ddlab.rnd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class BadObject {
	
	private String errMessage;
	
	private String errCode;
	

}
