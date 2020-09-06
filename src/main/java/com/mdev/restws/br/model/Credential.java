package com.mdev.restws.br.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Entity
@NoArgsConstructor
@Table(name = "credential", uniqueConstraints = @UniqueConstraint(name = "unq_credential_username", columnNames = "username"))
public class Credential implements Identifiable {

    @Id
    @Column(name = "id")
    @Setter(AccessLevel.PRIVATE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 4)
    @Column(name = "username", nullable = false)
    private String username;

    @Size(min = 4)
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role", nullable = false)
    private String role;

    @Builder
    public Credential(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
