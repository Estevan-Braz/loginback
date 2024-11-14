package com.example.demo.repository;

import com.example.demo.model.*;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.Optional;


public interface UsuarioRepositorio extends CrudRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
    boolean existsByEmail(String email);

    Usuario findByEmailAndSenha(String email, String senha);

    Iterable<Usuario> findByDataNascimentoIsBetween(Date start, Date end);

    Iterable<Usuario> findByUltimoLoginAfter(Date lastDay);
}
