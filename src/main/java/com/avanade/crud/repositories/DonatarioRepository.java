package com.avanade.crud.repositories;


import com.avanade.crud.domain.Donatario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonatarioRepository extends JpaRepository<Donatario,Long> {
}
