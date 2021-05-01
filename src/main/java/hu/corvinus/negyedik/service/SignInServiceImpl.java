package hu.corvinus.negyedik.service;

import hu.corvinus.negyedik.RegistrationAlreadyExistsException;
import hu.corvinus.negyedik.LoginFailedException;
import hu.corvinus.negyedik.dao.SignInDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SignInServiceImpl implements SignInService {

    private final SignInDao signInDao;

    @Override
    public void signIn(SignInData signInData) throws RegistrationAlreadyExistsException {

        Collection<SignInData> all = getAll();
        for(SignInData data: all){
            if(data.getUsername().equals(signInData.getUsername())){
                throw new RegistrationAlreadyExistsException();
            }
        }


        signInDao.save(
                hu.corvinus.negyedik.dao.SignInData.builder()
                        .name(signInData.getName())
                        .username(signInData.getUsername())
                        .pw(signInData.getPw())
                        .build()
        );

    }

    @Override
    public void logIn(LogInData logInData) throws LoginFailedException {

        Collection<LogInData> all = getUsernameAndPw();
        if(!all.contains(logInData)){
            throw new LoginFailedException();
        }
    }


    @Override
    public Collection<SignInData> getAll() {
        return signInDao.readAll().stream().map(
                daoSignIn -> SignInData.builder()
                        .name(daoSignIn.getName())
                        .username(daoSignIn.getUsername())
                        .pw(daoSignIn.getPw())
                        .build()
        ).collect(Collectors.toList());
    }

    @Override
    public Collection<LogInData> getUsernameAndPw() {
        return signInDao.readAll().stream().map(
                daoSignIn -> LogInData.builder()
                        .username(daoSignIn.getUsername())
                        .pw(daoSignIn.getPw())
                        .build()
        ).collect(Collectors.toList());
    }


}
