package com.Eccomerce.eccomerceAPI.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Eccomerce.eccomerceAPI.Models.Categoria;
import com.Eccomerce.eccomerceAPI.Models.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	public List<Produto> findAllByCategoria(Categoria categoria);

}
