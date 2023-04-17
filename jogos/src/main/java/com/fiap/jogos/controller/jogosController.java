package com.fiap.jogos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.jogos.dto.DadosCadastroJogos;
import com.fiap.jogos.dto.DadosId;
import com.fiap.jogos.dto.DadosListagemJogos;
import com.fiap.jogos.dto.DadosUpdateJogos;
import com.fiap.jogos.entity.Jogo;
import com.fiap.jogos.model.JogosRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/jogos")
public class jogosController {
	
	@Autowired
	private JogosRepository repository;
	
	//Post
	@PostMapping
	@Transactional
	public void cadastro(@RequestBody @Valid DadosCadastroJogos dados) {
		repository.save(new Jogo(dados));
	}	
	//Get
	@GetMapping
	public Page<DadosListagemJogos> listar(
			@PageableDefault(size=5, sort={"titulo"})Pageable paginacao){
		return repository.findAllByAtivoTrue(paginacao).map(DadosListagemJogos :: new);
	};
	//Put
	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid DadosUpdateJogos dados) {
		Jogo jogo = new Jogo();
		jogo = repository.getReferenceById(dados.id());
		jogo.updateJogo(dados);
	}
	//Delete
	@DeleteMapping
	@Transactional
	public void delete (@RequestBody DadosId dados) {
		Jogo jogo = new Jogo();
		jogo = repository.getReferenceById(dados.id());
		jogo.deleteJogo(dados);
	}
}
