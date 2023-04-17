package com.fiap.jogos.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.jogos.entity.Jogo;

public interface JogosRepository extends JpaRepository<Jogo, Long>{
	Page<Jogo> findAllByAtivoTrue(Pageable paginacao);
}
