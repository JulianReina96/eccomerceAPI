package com.Eccomerce.eccomerceAPI.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToOne;

@Entity(name="produto")
public class Produto {
	
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String Nome;
	private String descricao;
	private double preco;
	private int QuantidadeEstoque;
	@OneToOne
	private Categoria categoria;
	
	
	public Produto(String nome, String descricao, double preco, int quantidadeEstoque, Categoria categoria) {
		super();
		Nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		QuantidadeEstoque = quantidadeEstoque;
		this.categoria = categoria;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
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
	

}
