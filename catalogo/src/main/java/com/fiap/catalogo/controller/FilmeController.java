package com.fiap.catalogo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.catalogo.model.dto.DadosCadastroFilme;
import com.fiap.catalogo.model.dto.FilmeRepository;
import com.fiap.catalogo.model.entity.Filme;




@RestController
@RequestMapping("/filmes")
public class FilmeController {
	
	@Autowired
	private FilmeRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody DadosCadastroFilme dados) {
		repository.save(new Filme(dados));
	}
}
