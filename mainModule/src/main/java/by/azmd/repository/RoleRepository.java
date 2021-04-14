package by.azmd.repository;

import by.azmd.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Modifying()
    @Query(value = "insert into user_bk_roles (user_id, roles_id) values (?, 1)", nativeQuery = true)
    @Transactional
    void setRoleUser(Long userId);
}
