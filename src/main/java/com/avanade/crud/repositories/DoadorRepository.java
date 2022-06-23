package com.avanade.crud.repositories;

import com.avanade.crud.domain.Doador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoadorRepository extends JpaRepository<Doador,Long> {
}
