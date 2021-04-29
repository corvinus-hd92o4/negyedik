package hu.corvinus.negyedik.service;

import hu.corvinus.negyedik.dao.SignInDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignInServiceImpl implements SignInService {

    private final SignInDao signInDao;

    @Override
    public void signIn(SignInData signInData) {

        signInDao.save(
                hu.corvinus.negyedik.dao.SignInData.builder()
                        .name(signInData.getName())
                        .username(signInData.getUsername())
                        .pw(signInData.getPw())
                        .build()
        );

    }
}
