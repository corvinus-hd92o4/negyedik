package hu.corvinus.negyedik.dao.entitiy;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class SignInEntitiy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column()
    private String name;
    @Column()
    private String username;
    @Column()
    private int password_hash;

}
