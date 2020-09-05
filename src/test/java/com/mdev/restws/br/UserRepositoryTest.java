package com.mdev.restws.br;

import com.mdev.restws.br.model.User;
import com.mdev.restws.br.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolationException;
import java.util.Date;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {

    public static final String valid_username = "valid_username";
    public static final String invalid_username = "inv";
    public static final String valid_password = "valid_password";
    public static final String invalid_password = "inv";

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private UserRepository userRepository;

    @Test(expected = ConstraintViolationException.class)
    public void whenPersistWithInvalidUsername_thenThrowConstraintViolation(){
        userRepository.save(User.builder().username(invalid_username).password(valid_password).addedAt(new Date()).build());
    }

    @Test(expected = ConstraintViolationException.class)
    public void whenPersistWithInvalidPassword_thenThrowConstraintViolation(){
        userRepository.save(User.builder().username(valid_username).password(invalid_password).addedAt(new Date()).build());
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void whenPersistWithExistingUsername_thenThrowDataIntegrityViolationException(){
        userRepository.save(User.builder().username(valid_username).password(valid_password).addedAt(new Date()).build());
        userRepository.save(User.builder().username(valid_username).password(valid_password).addedAt(new Date()).build());
    }

    @Test
    public void whenFindByUsername_thenReturnUser() {
        User stub = User.builder().username(valid_username).password(valid_password).addedAt(new Date()).build();
        testEntityManager.persist(stub);
        testEntityManager.flush();
        User found = userRepository.findByUsername(stub.getUsername());
        assertThat(found.getUsername()).isEqualTo(stub.getUsername());
    }
}
