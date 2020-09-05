package com.mdev.restws.br;

import com.mdev.restws.br.model.Post;
import com.mdev.restws.br.model.User;
import com.mdev.restws.br.repository.PostRepository;
import com.mdev.restws.br.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolationException;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@RunWith(SpringRunner.class)
public class PostRepositoryTest {

    public static final String post_value = "this is a post";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Test(expected = DataIntegrityViolationException.class)
    public void whenPersistWithoutUser_thenThrowConstraintViolationException() {
        postRepository.save(Post.builder().post(post_value).build());
    }

    @Test
    public void whenFindByUserAndPostId_thenReturnPost() {
        User user = userRepository.save(User.builder().username(UserRepositoryTest.valid_username).password(UserRepositoryTest.valid_password).addedAt(new Date()).build());
        Post post = postRepository.save(Post.builder().user(user).post(post_value).build());
        Post found = postRepository.findByUserAndId(user, post.getId());
        assertThat(found).isNotNull();
        assertThat(found.getId()).isEqualTo(post.getId());
    }
}
