package com.mdev.restws.br.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@NoArgsConstructor
@Table(name = "post")
public class Post implements Identifiable {

    @Id
    @Column(name = "id")
    @Setter(AccessLevel.PRIVATE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "user", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_post_user"))
    private User user;

    @Column(name = "post", nullable = false)
    @Size(min = 1)
    private String post;

    @Builder
    public Post(User user, String post) {
        this.user = user;
        this.post = post;
    }
}
