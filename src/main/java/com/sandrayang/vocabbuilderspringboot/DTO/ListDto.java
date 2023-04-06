package com.sandrayang.vocabbuilderspringboot.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter
public class ListDto {
	private long listID;
	private UserDto userDtoObj;
}
