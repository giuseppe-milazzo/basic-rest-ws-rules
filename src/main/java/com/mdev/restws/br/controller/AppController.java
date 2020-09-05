package com.mdev.restws.br.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.mdev.restws.br.model.Post;
import com.mdev.restws.br.model.User;
import com.mdev.restws.br.repository.PostRepository;
import com.mdev.restws.br.repository.UserRepository;
import com.mdev.restws.br.utils.JsonViews;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@RestController
public class AppController {

    private static final Logger logger = LogManager.getLogger(AppController.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/user/{userId}")
    @JsonView(JsonViews.Public.class)
    public User findUser(@PathVariable Long userId) {
        return userRepository.findById(userId).orElseThrow(EntityNotFoundException::new);
    }

    @GetMapping("/user")
    @JsonView(JsonViews.Public.class)
    public List<User> findUser() {
        return userRepository.findAll();
    }

    @PostMapping("/user")
    @JsonView(JsonViews.Private.class)
    public ResponseEntity<?> addUser(@Valid @RequestBody User user) {
        if (Objects.nonNull(user.getId())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        user.setAddedAt(new Date());
        return ResponseEntity.created(
                ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{userId}")
                        .buildAndExpand(
                                userRepository
                                        .save(user)
                        )
                        .toUri()
        ).build();
    }

    @DeleteMapping("/user/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userRepository.deleteById(userId);
    }

    @PutMapping("/user/{userId}")
    @JsonView(JsonViews.Private.class)
    public void updateUser(@PathVariable Long userId, @Valid @RequestBody User user) {
        User u = userRepository.findById(userId).orElseThrow(EntityNotFoundException::new);
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        userRepository.save(user);
    }

    @GetMapping("/user/{userId}/post/{postId}")
    public Post findPost(@PathVariable Long userId, @PathVariable Long postId) {
        Post post = postRepository.findByUserAndId(
                userRepository.findById(userId).orElseThrow(EntityNotFoundException::new),
                postId);
        if (Objects.isNull(post)) {
            throw new EntityNotFoundException();
        }
        return post;
    }

    @GetMapping("/user/{userId}/post")
    public List<Post> findPost(@PathVariable Long userId) {
        return postRepository.findByUser(userRepository.findById(userId).orElseThrow(EntityNotFoundException::new));
    }

    @PostMapping("/user/{userId}/post")
    public ResponseEntity<?> addPost(@PathVariable Long userId, @Valid @RequestBody Post post) {
        if (Objects.nonNull(post.getId())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        post.setUser(userRepository.findById(userId).orElseThrow(EntityNotFoundException::new));
        return ResponseEntity.created(
                ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{postId}")
                        .buildAndExpand(
                                postRepository
                                        .save(post)
                        )
                        .toUri()
        ).build();
    }

    @DeleteMapping("/user/{userId}/post/{postId}")
    public void deletePost(@PathVariable Long userId, @PathVariable Long postId) {
        Post post = postRepository.findByUserAndId(
                userRepository.findById(userId).orElseThrow(EntityNotFoundException::new),
                postId);
        if (Objects.isNull(post)) {
            throw new EntityNotFoundException();
        }
        postRepository.delete(post);
    }

    @PutMapping("/user/{userId}/post/{postId}")
    public void updatePost(@PathVariable Long userId, @PathVariable Long postId, @Valid @RequestBody Post post) {
        Post p = postRepository.findByUserAndId(
                userRepository.findById(userId).orElseThrow(EntityNotFoundException::new),
                postId);
        if (Objects.isNull(p)) {
            throw new EntityNotFoundException();
        }
        p.setPost(post.getPost());
        postRepository.save(post);
    }
}
