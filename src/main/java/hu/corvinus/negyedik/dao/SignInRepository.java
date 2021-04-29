package hu.corvinus.negyedik.dao;

import org.springframework.data.repository.CrudRepository;
import hu.corvinus.negyedik.dao.entitiy.SignInEntitiy;

public interface SignInRepository extends CrudRepository<SignInEntitiy, Long> {
}
