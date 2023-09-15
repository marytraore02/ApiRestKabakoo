package com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.Repositories;

import com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.Models.ERole;
import com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole role);
}

