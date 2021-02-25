package com.backfarmacia.Back.End.Farmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backfarmacia.Back.End.Farmacia.model.ModelCategoria;

public interface RepCategoria extends JpaRepository<ModelCategoria, Long>{
	public List<ModelCategoria> findAllByNomeContainingIgnoreCase (String nome);

}
