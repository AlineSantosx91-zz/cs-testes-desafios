package br.com.concrete.desafios.register.service;

import br.com.concrete.desafios.register.model.User;
import br.com.concrete.desafios.register.repository.UserRegisterRepository;

public class UserRegisterService {

    private final UserRegisterRepository userRegisterRepository;

    public UserRegisterService(UserRegisterRepository userRegisterRepository) {
        this.userRegisterRepository = userRegisterRepository;
    }

    public User saveUser(User user) {
        return userRegisterRepository.save(user);
    }
}
