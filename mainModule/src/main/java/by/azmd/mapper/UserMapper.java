package by.azmd.mapper;

import by.azmd.dto.UserDTO;
import by.azmd.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements DtoMapper<UserDTO, User> {
    private final ObjectMapper mapper;

    public UserMapper(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public UserDTO toDTO(User entity) {
        return mapper.convertValue(entity, UserDTO.class);
    }

    @Override
    public User toEntity(UserDTO dto) {
        return mapper.convertValue(dto, User.class);
    }
}
