package by.azmd.service;

import by.azmd.dto.UserDTO;
import by.azmd.entity.Role;
import by.azmd.entity.User;
import by.azmd.mapper.DtoMapper;
import by.azmd.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class UserService {
    private final DtoMapper<UserDTO, User> mapper;
    private final UserRepository userRepository;

    public ResponseEntity<UserDTO> addNewUser(UserDTO userDTO) {
        User user = userRepository.findByUsername(userDTO.getUsername());
        if (user == null) {
            saveUser(userDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        throw  new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

    private void saveUser(UserDTO dto) {
        User user = mapper.toEntity(dto);
        user.setPassword(new BCryptPasswordEncoder().encode(dto.getPassword()));
        user.setRole(Role.USER);
        userRepository.save(user);
    }

    protected User getAuthenticationUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return userRepository.findByUsername(auth.getName());
    }

    public void updateQuantityBook(int quantityBook, Long userID) {
        userRepository.updateQuantityBook(quantityBook, userID);
    }

    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}