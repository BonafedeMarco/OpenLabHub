package com.example.spaceappchallenge.service.implementations;

import com.example.spaceappchallenge.dto.request.CreateTagDto;
import com.example.spaceappchallenge.dto.request.CreateUserDto;
import com.example.spaceappchallenge.dto.response.RespMessage;
import com.example.spaceappchallenge.dto.response.UserDto;
import com.example.spaceappchallenge.enums.ResponseMessages;
import com.example.spaceappchallenge.exception.NotFoundException;
import com.example.spaceappchallenge.model.Application;
import com.example.spaceappchallenge.model.Tag;
import com.example.spaceappchallenge.model.User;
import com.example.spaceappchallenge.repository.IUserRepository;
import com.example.spaceappchallenge.service.Interfaces.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    private IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDto findById(long id) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        if (!userRepository.existsById(id))
            throw new NotFoundException(String.format(ResponseMessages.USER_NOT_FOUND.toString(), id));

        User userReturned = userRepository.findById(id).get();

        return mapper.convertValue(userReturned, UserDto.class);
    }

    @Override
    public Set<UserDto> findAll() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        List<User> usersReturned = userRepository.findAll();

        if (usersReturned.isEmpty())
            throw new NotFoundException("User list is empty");

        return usersReturned.stream()
                .map(u -> mapper.convertValue(u, UserDto.class))
                .collect(Collectors.toSet());
    }

    @Override
    public RespMessage addUser(CreateUserDto dto) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        User newUser = new User();

        Set<Tag> tags = dto.getRelatedTags().stream()
                .map(t -> mapper.convertValue(t, Tag.class))
                .collect(Collectors.toSet());
        newUser.setRelatedTags(tags);
        newUser.setUsername(dto.getUsername());
        newUser.setEmail(dto.getEmail());
        newUser.setPassword(dto.getPassword());
        newUser.setDescription(dto.getDescription());

        RespMessage respMessage = new RespMessage();

        User userCreated = userRepository.save(newUser);

        respMessage.setId(userCreated.getUserId());
        respMessage.setMessage("User created succesfully ;)");

        return respMessage;
    }

    @Override
    public long deleteUser(long id) {
        return 0;
    }

    @Override
    public long updateUser(long id, UserDto dto) {
        return 0;
    }
}
