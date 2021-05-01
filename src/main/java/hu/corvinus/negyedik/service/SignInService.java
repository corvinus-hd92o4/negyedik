package hu.corvinus.negyedik.service;

import hu.corvinus.negyedik.RegistrationAlreadyExistsException;
import hu.corvinus.negyedik.LoginFailedException;

import java.util.Collection;

public interface SignInService {
    void signIn(SignInData signInData) throws RegistrationAlreadyExistsException;
    void logIn(LogInData logInData) throws LoginFailedException;
    Collection<SignInData> getAll();
    Collection<LogInData> getUsernameAndPw();
}
