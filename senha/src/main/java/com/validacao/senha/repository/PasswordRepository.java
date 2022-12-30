package com.validacao.senha.repository;

import com.validacao.senha.model.Password;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PasswordRepository extends JpaRepository<Password, Long> {
}
