package com.Eccomerce.eccomerceAPI.Controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.Eccomerce.eccomerceAPI.Repository.ProdutoRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import com.Eccomerce.eccomerceAPI.DTOs.ProdutosDTO;
import com.Eccomerce.eccomerceAPI.Models.Categoria;
import com.Eccomerce.eccomerceAPI.Models.Produto;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository repository;
	
	@GetMapping	
	public List<ProdutosDTO> listar() {
		return ProdutosDTO.converte(repository.findAll());
	}
	
	@GetMapping("/produtos/")
	public List<ProdutosDTO> listarByCategoria(Categoria categoria){
		
		return ProdutosDTO.converte(repository.findAllByCategoria(categoria));
		
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<ProdutosDTO> cadastrar(@RequestBody ProdutosDTO produtosDTO, UriComponentsBuilder uriBuilder) {
		Produto produto= produtosDTO.converter(repository);
		repository.save(produto);
		URI uri=uriBuilder.path("/posts/{id}").buildAndExpand(produto.getId()).toUri();
		return ResponseEntity.created(uri).body(new ProdutosDTO(produto));
		}

	
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ProdutosDTO> atualizar(@PathVariable Long id, @RequestBody @Valid ProdutosDTO produtoDTO) {
				
		Produto produto = produtoDTO.atualiza(repository, id);
		return new ResponseEntity<ProdutosDTO>(new ProdutosDTO(produto),HttpStatus.OK);
	
		}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deletar(@PathVariable Long id) {
		repository.deleteById(id); 
		return new ResponseEntity<>(HttpStatus.OK);
	}


	
	


}
