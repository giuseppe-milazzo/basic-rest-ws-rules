package com.mdev.restws.br.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.mdev.restws.br.utils.JsonViews;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.lang.annotation.RetentionPolicy;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table(name = "user", uniqueConstraints = @UniqueConstraint(name = "unq_user_username", columnNames = "username"))
public class User implements Identifiable {

    @Id
    @Column(name = "id")
    @JsonView(JsonViews.Public.class)
    @Setter(AccessLevel.PRIVATE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 6)
    @JsonView(JsonViews.Public.class)
    @Column(name = "username", nullable = false)
    private String username;

    @Size(min = 6)
    @JsonView(JsonViews.Private.class)
    @Column(name = "password", nullable = false)
    private String password;

    @JsonView(JsonViews.Public.class)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "addedAt", nullable = false)
    private Date addedAt = new Date();

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<Post> posts = new HashSet<>();

    @Builder
    public User(String username, String password, Date addedAt) {
        this.username = username;
        this.password = password;
        this.addedAt = addedAt;
    }
}
