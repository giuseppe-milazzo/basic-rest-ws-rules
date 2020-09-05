package com.mdev.restws.br.repository;

import com.mdev.restws.br.model.Post;
import com.mdev.restws.br.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByUser(User user);
    Post findByUserAndId(User user, Long id);
}
