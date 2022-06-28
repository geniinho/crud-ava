package com.avanade.crud.repositories;


import com.avanade.crud.domain.Donatario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DonatarioRepository extends JpaRepository<Donatario,Integer> {
    Optional<Donatario> findByEmail(String email);
}
