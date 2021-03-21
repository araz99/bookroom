package by.azmd.controller;

import by.azmd.dto.UserDTO;
import by.azmd.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // add new user
    @PostMapping
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO dto) {
        return userService.addNewUser(dto);
    }
}
