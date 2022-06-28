package com.avanade.crud.repositories;

import com.avanade.crud.domain.Doador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoadorRepository extends JpaRepository<Doador,Integer> {
    Optional<Doador> findByEmail(String email);
}
