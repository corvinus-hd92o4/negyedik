package hu.corvinus.negyedik.controller;

import hu.corvinus.negyedik.controller.dto.SignInDto;
import hu.corvinus.negyedik.service.SignInData;
import hu.corvinus.negyedik.service.SignInService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/negyedik")
@RequiredArgsConstructor
public class RegistController {

    private final SignInService signInService;

    @PostMapping("/sign-up")
    public String signIn( @Valid @RequestBody SignInDto signInDto){
                signInService.signIn(
                        SignInData.builder()
                                .name(signInDto.getName())
                                .username(signInDto.getUsername())
                                .pw(signInDto.getPw())
                                .build()
                );
                return "elvileg ez jo";
    }

}
