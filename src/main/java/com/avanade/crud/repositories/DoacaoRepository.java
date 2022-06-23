package com.avanade.crud.repositories;

import com.avanade.crud.domain.Doacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoacaoRepository extends JpaRepository<Doacao,Long> {
}
