package me.estudo.aplicacao_nuvem.service;

import me.estudo.aplicacao_nuvem.domain.model.User;

public interface UserService {
    User findById(Long id);

    User create(User userToCreate);


}
