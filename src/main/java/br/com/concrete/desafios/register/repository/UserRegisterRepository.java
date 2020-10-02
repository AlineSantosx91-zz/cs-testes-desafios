package br.com.concrete.desafios.register.repository;

import br.com.concrete.desafios.register.model.User;

public interface UserRegisterRepository {

    User save(User user);
}
