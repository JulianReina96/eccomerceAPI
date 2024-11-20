package com.Eccomerce.eccomerceAPI.DTOs;

import java.util.List;
import java.util.stream.Collectors;

import com.Eccomerce.eccomerceAPI.Models.Cliente;
import com.Eccomerce.eccomerceAPI.Models.Endereco;
import com.Eccomerce.eccomerceAPI.Models.Produto;
import com.Eccomerce.eccomerceAPI.Repository.ClienteRepository;
import com.Eccomerce.eccomerceAPI.Repository.ProdutoRepository;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ClienteDTO {
	
	private Long id;
	@NotNull(message = "O nome não pode ser nulo")
	private String nome;
	@NotBlank(message = "O email não pode ser vazio")
	private String email;
	@NotBlank(message = "É preciso inserir um telefone")
	private String telefone;	
	@NotNull(message = "O endereço não pode ser nulo")
	private Endereco endereco;

	
	
	
	public ClienteDTO(Cliente cliente) {
		super();
		this.nome = cliente.getNome();
		this.email = cliente.getEmail();
		this.telefone = cliente.getTelefone();
		this.endereco = cliente.getEndereco();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


	public static List<ClienteDTO> converte(List<Cliente> list){
		return list.stream().map(ClienteDTO::new).collect(Collectors.toList());	
	}
	
	public static ClienteDTO converte(Cliente cliente){
		return new ClienteDTO(cliente);
	}
	

	
	
	public Cliente atualiza(ClienteRepository repository, Long id) {
		Cliente cliente=repository.getById(id);
		cliente.setNome(nome);
		cliente.setEmail(email); 
		cliente.setTelefone(telefone);
		cliente.setEndereco(endereco);		
		return cliente;
	}

	
	public Cliente converter(ClienteRepository clienteRepositorio) {
 
		Cliente cliente = new Cliente(nome, email,  telefone, endereco);
		
		return cliente;
}
	
	
}
