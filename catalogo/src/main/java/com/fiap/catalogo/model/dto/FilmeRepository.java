package com.fiap.catalogo.model.dto;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.catalogo.model.entity.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long>{

}
