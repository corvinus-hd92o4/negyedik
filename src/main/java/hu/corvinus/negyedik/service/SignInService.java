package hu.corvinus.negyedik.service;

import hu.corvinus.negyedik.RegistrationAlreadyExistsException;
import hu.corvinus.negyedik.RegistrationDoesNotExistException;

import java.util.Collection;

public interface SignInService {
    void signIn(SignInData signInData) throws RegistrationAlreadyExistsException;
    void logIn(LogInData logInData) throws RegistrationDoesNotExistException;
    Collection<SignInData> getAll();
    Collection<LogInData> getUsernameAndPw();
}
