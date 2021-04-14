package by.azmd.service;

import by.azmd.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository repository;

    public void setRoleUser(Long userId) {
        repository.setRoleUser(userId);
    }
}
