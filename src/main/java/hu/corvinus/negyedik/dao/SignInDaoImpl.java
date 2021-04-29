package hu.corvinus.negyedik.dao;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SignInDaoImpl implements SignInDao {


    private final List<SignInData> signInDataList = new ArrayList<>();

    @Override
    public void save(SignInData signInData) {
        signInDataList.add(signInData);
    }
}
