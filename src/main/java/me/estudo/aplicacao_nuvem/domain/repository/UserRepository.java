package me.estudo.aplicacao_nuvem.domain.repository;

import me.estudo.aplicacao_nuvem.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
