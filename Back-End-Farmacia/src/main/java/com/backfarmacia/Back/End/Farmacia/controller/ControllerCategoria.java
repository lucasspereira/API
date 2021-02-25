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

import com.backfarmacia.Back.End.Farmacia.model.ModelCategoria;
import com.backfarmacia.Back.End.Farmacia.repository.RepCategoria;

@RestController
@RequestMapping("/Categoria")
@CrossOrigin("*")
public class ControllerCategoria {

	@Autowired
	private RepCategoria repository;

	@GetMapping
	public ResponseEntity<List<ModelCategoria>> GetCategoria() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ModelCategoria> GetByID(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping ("/nome/{nome}")
	public ResponseEntity<List<ModelCategoria>> GetByNome (@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));		
	}
	
	@PostMapping
	public ResponseEntity<ModelCategoria> PostCategoria (@RequestBody ModelCategoria categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
	}
	
	@PutMapping
	public ResponseEntity<ModelCategoria> PutCategoria (@RequestBody ModelCategoria categoria){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(categoria));
	}
	
	@DeleteMapping ("/{id}")
	public void DeleteCategoria (@PathVariable long id) {
		repository.deleteById(id);
	}

}
