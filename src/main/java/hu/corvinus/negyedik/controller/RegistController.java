package hu.corvinus.negyedik.controller;

import hu.corvinus.negyedik.RegistrationAlreadyExistsException;
import hu.corvinus.negyedik.RegistrationDoesNotExistException;
import hu.corvinus.negyedik.controller.dto.LogInDto;
import hu.corvinus.negyedik.controller.dto.SignInDto;
import hu.corvinus.negyedik.service.LogInData;
import hu.corvinus.negyedik.service.SignInData;
import hu.corvinus.negyedik.service.SignInService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/negyedik")
@RequiredArgsConstructor
public class RegistController {

    private final SignInService signInService;

    @PostMapping("/sign-up")
    public void signIn( @Valid @RequestBody SignInDto signInDto){
        try {
            signInService.signIn(
                    SignInData.builder()
                            .name(signInDto.getName())
                            .username(signInDto.getUsername())
                            .pw((signInDto.getPw()).hashCode())
                            .build()
            );
        } catch (RegistrationAlreadyExistsException e) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    e.getMessage()
            );
        }
    }

    @PostMapping("/log-in")
    public void logIn(@RequestBody LogInDto logInDto){
        try {
            signInService.logIn(
                    LogInData.builder()
                            .username(logInDto.getUsername())
                            .pw((logInDto.getPw()).hashCode())
                            .build()
            );
        } catch (RegistrationDoesNotExistException e) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    e.getMessage()
            );
        }
    }

}
