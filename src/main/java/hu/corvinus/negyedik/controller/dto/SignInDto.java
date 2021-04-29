package hu.corvinus.negyedik.controller.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;
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
    @Size (min = 8, message = "Password must be at least 8 characters long")
    private String pw;
}
