package com.mysite.sns;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	private String id;
	private String name;
	private String email;
	private String avatar;
	private String postImage;
	private String bio;
	private boolean isGoldMemeber;
}
