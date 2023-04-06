package com.sandrayang.vocabbuilderspringboot.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter
public class UserDto {
	private long UserID;
	private ListDto listDtoObj;
}
