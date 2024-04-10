package com.cts.lms.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {
	
	private Long id;
	
	@NotBlank
	private String name;
	
	@Email(regexp = "^[a-zA-Z0-9]+@[a-zA-Z]+\\.com$")
	@NotNull
	private String email;
	
	@NotNull
	@Pattern(regexp = "^[a-zA-Z0-9]{8,}$")
	private String password;

}
