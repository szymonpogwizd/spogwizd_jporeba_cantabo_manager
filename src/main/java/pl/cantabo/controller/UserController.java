package pl.cantabo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.cantabo.database.user.UserInfoDTO;
import pl.cantabo.database.user.UserMapper;
import pl.cantabo.database.user.UserType;
import pl.cantabo.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@RestController
@RequestMapping("/dashboard/users")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping
    public List<UserInfoDTO> getAll() {
        log.debug("Getting all users");
        return log.traceExit(
                userService.getAll()
                        .stream()
                        .map(userMapper::userDAO2UserInfoDTO)
                        .collect(Collectors.toList())
        );
    }

    @GetMapping("/userTypes")
    public List<UserType> getUserType() {
        log.debug("Getting all user types");
        return log.traceExit(
                new ArrayList<>(userService.getAllUserTypes())
        );
    }
}
