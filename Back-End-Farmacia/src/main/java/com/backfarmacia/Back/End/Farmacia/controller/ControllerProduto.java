package com.backfarmacia.Back.End.Farmacia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backfarmacia.Back.End.Farmacia.model.ModelProduto;
import com.backfarmacia.Back.End.Farmacia.repository.RepProduto;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping ("/produto")
public class ControllerProduto {

	@Autowired
	private RepProduto repository;

	@GetMapping
	public ResponseEntity<List<ModelProduto>> GetProduto() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<ModelProduto> GetByID(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<ModelProduto>> GetByNome(@PathVariable String nome) {
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}

	@PostMapping
	public ResponseEntity<ModelProduto> PostProduto(@RequestBody ModelProduto produto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
	}

	@PutMapping
	public ResponseEntity<ModelProduto> PutProduto(@RequestBody ModelProduto produto) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(produto));
	}

	@DeleteMapping("/{id}")
	public void DeleteProduto(@PathVariable long id) {
		repository.deleteById(id);

	}
}
