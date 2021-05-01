package hu.corvinus.negyedik.controller.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
//@Builder
@RequiredArgsConstructor
public class SignInDto {

    @NotNull(message = "Name cannot be empty")
    private String name;

    @NotNull(message = "Username cannot be empty")
    @Size(min = 6,message = "Username must be at least 6 characters long")
    private String username;

    @NotNull (message = "Password cannot be empty")
    @Pattern(regexp = "(?!^[0-9]*$)(?!^[a-zA-Z]*$)^([a-zA-Z0-9]{8,})$")
    private String pw;
}
