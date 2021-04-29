package hu.corvinus.negyedik.dao;

import java.util.Collection;

public interface SignInDao {
    Collection<SignInData> readAll();
    void save (SignInData signInData);

}
