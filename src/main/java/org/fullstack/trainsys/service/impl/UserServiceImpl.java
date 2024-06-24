package org.fullstack.trainsys.service.impl;

import org.fullstack.trainsys.entity.UserEntity;
import org.fullstack.trainsys.repository.UserRepository;
import org.fullstack.trainsys.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity createUser(UserEntity user) {
        logger.info("Adicionado novo usuário: {}", user);
        return userRepository.save(user);
    }
}
