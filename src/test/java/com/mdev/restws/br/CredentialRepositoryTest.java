package com.mdev.restws.br;

import com.mdev.restws.br.model.Credential;
import com.mdev.restws.br.repository.CredentialRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@RunWith(SpringRunner.class)
public class CredentialRepositoryTest {

    public static final String username = "username";
    public static final String password = "password";

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private CredentialRepository credentialRepository;

    @Test
    public void whenFindByUsername_thenReturnUser() {
        Credential stub = Credential.builder().username(username).password(password).role("USER").build();
        testEntityManager.persist(stub);
        testEntityManager.flush();
        Optional<Credential> credential = credentialRepository.findByUsername(stub.getUsername());
        assertThat(credential.get().getUsername()).isEqualTo(stub.getUsername());
    }

    @Test(expected = NoSuchElementException.class)
    public void whenFindByUsername_andUsernameNotExist_thenThrowNoSuchElementException() {
        Optional<Credential> credential = credentialRepository.findByUsername(username);
        credential.get();
    }
}
