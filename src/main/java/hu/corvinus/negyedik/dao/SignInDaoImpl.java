package hu.corvinus.negyedik.dao;

import hu.corvinus.negyedik.dao.entitiy.SignInEntitiy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
@Slf4j
@RequiredArgsConstructor
public class SignInDaoImpl implements SignInDao {

    private final SignInRepository signInRepository;

    @Override
    public Collection<SignInData> readAll() {
        return StreamSupport.stream(signInRepository.findAll().spliterator(),false).
                map(entity -> SignInData.builder()
                        .name(entity.getName())
                        .username(entity.getUsername())
                        .pw(entity.getPassword_hash())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public void save(SignInData signInData) {
        //signInDataList.add(signInData);
        hu.corvinus.negyedik.dao.entitiy.SignInEntitiy entitiy =
                new hu.corvinus.negyedik.dao.entitiy.SignInEntitiy();
        entitiy.setName(signInData.getName());
        entitiy.setUsername(signInData.getUsername());
        entitiy.setPassword_hash(signInData.getPw());
        signInRepository.save(entitiy);
    }
}
