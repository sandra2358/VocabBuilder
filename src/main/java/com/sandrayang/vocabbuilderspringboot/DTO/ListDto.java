package com.sandrayang.vocabbuilderspringboot.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter
public class ListDto {
	private long listID;
	@JsonIgnore
	private UserDto userDtoObj;
	
	public long getListID() {
		return listID;
	}
	public void setListID(long listID) {
		this.listID = listID;
	}
	public UserDto getUserDtoObj() {
		return userDtoObj;
	}
	public void setUserDtoObj(UserDto userDtoObj) {
		this.userDtoObj = userDtoObj;
	}
	
	
}
