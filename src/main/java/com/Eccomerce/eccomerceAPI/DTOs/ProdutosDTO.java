package com.Eccomerce.eccomerceAPI.DTOs;

import java.util.List;
import java.util.stream.Collectors;

import com.Eccomerce.eccomerceAPI.Models.Categoria;
import com.Eccomerce.eccomerceAPI.Models.Produto;
import com.Eccomerce.eccomerceAPI.Repository.ProdutoRepository;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProdutosDTO {
	private Long Id;	
	@NotNull(message = "O nome não pode ser nulo") 

	private String Nome;
	@NotBlank(message = "A descrição não pode ser vazia")
	private String descricao;
	@NotNull(message = "O nome não pode ser nulo") 
	private double preco;
	private int QuantidadeEstoque;
	@NotBlank(message = "A descrição não pode ser vazia")
	private Categoria categoria;
	
	

	
	
	
	public ProdutosDTO(Produto produto) {
		super();
		Id = produto.getId();
		Nome = produto.getNome();
		this.descricao = produto.getDescricao();
		this.preco = produto.getPreco();
		QuantidadeEstoque = produto.getQuantidadeEstoque();
		this.categoria = produto.getCategoria();
	}


	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}


	public int getQuantidadeEstoque() {
		return QuantidadeEstoque;
	}


	public void setQuantidadeEstoque(int quantidadeEstoque) {
		QuantidadeEstoque = quantidadeEstoque;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	public static List<ProdutosDTO> converte(List<Produto> lista){
		return lista.stream().map(ProdutosDTO::new).collect(Collectors.toList());	
	}
	
	
	public Produto atualiza(ProdutoRepository repository, Long id) {
		Produto produto=repository.getById(id);
		produto.setNome(Nome);
		produto.setDescricao(descricao); 
		produto.setCategoria(categoria);
		produto.setPreco(preco);
		produto.setQuantidadeEstoque(QuantidadeEstoque);
		return produto;
	}

	
	public Produto converter(ProdutoRepository produtoRepositorio) {
 
		Produto produto = new Produto(Nome, descricao,  preco, QuantidadeEstoque, categoria);
		
		return produto;
}
	}
