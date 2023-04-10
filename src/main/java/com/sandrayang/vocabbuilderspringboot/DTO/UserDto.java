package com.sandrayang.vocabbuilderspringboot.DTO;

import java.util.Set;

import com.sandrayang.vocabbuilderspringboot.model.Lists;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter
public class UserDto {
	private long UserID;
	private ListDto listDtoObj;
	private String username;
	private String firstname;
	private String lastname;
	private String email;
	private Set<Lists> subscribedList;
	private Set<Lists> createdList;
	
	public long getUserID() {
		return UserID;
	}
	public void setUserID(long userID) {
		UserID = userID;
	}
	public ListDto getListDtoObj() {
		return listDtoObj;
	}
	public void setListDtoObj(ListDto listDtoObj) 	{
		this.listDtoObj = listDtoObj;
	}
}
