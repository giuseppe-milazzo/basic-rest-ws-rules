package com.mdev.restws.br.repository;

import com.mdev.restws.br.model.Identifiable;
import com.mdev.restws.br.model.User;

import java.util.List;

public interface TestRepository<T extends Identifiable> {

    T save();

    T update();

    void delete();

    User find(Long id);

    List<User> find();
}
