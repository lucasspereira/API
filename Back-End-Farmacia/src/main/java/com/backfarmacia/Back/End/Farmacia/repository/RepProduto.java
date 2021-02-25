package com.backfarmacia.Back.End.Farmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backfarmacia.Back.End.Farmacia.model.ModelProduto;

public interface RepProduto extends JpaRepository<ModelProduto, Long>{
	public List<ModelProduto> findAllByNomeContainingIgnoreCase (String nome);

}
