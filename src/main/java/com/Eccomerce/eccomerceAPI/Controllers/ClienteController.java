package com.Eccomerce.eccomerceAPI.Controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

import com.Eccomerce.eccomerceAPI.DTOs.ClienteDTO;
import com.Eccomerce.eccomerceAPI.DTOs.ClienteDTO;
import com.Eccomerce.eccomerceAPI.Models.Categoria;
import com.Eccomerce.eccomerceAPI.Models.Cliente;
import com.Eccomerce.eccomerceAPI.Repository.ClienteRepository;
import com.Eccomerce.eccomerceAPI.Repository.ClienteRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	
	@Autowired
	private ClienteRepository repository;
	
	@GetMapping	
	public List<ClienteDTO> listar() {
		return ClienteDTO.converte(repository.findAll());
	}
	
	

@GetMapping("/{id}")
public ClienteDTO buscarPorId(@PathVariable Long id) {
    Optional<Cliente> cliente = repository.findById(id);
    return cliente.map(ClienteDTO::converte)
                  .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
}

	
	
	
	@PostMapping("/cadastrar")
	public ResponseEntity<ClienteDTO> cadastrar(@RequestBody ClienteDTO ClienteDTO, UriComponentsBuilder uriBuilder) {
		Cliente Cliente= ClienteDTO.converter(repository);
		repository.save(Cliente);
		URI uri=uriBuilder.path("/posts/{id}").buildAndExpand(Cliente.getId()).toUri();
		return ResponseEntity.created(uri).body(new ClienteDTO(Cliente));
		}

	
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ClienteDTO> atualizar(@PathVariable Long id, @RequestBody @Valid ClienteDTO ClienteDTO) {
				
		Cliente Cliente = ClienteDTO.atualiza(repository, id);
		return new ResponseEntity<ClienteDTO>(new ClienteDTO(Cliente),HttpStatus.OK);
	
		}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deletar(@PathVariable Long id) {
		repository.deleteById(id); 
		return new ResponseEntity<>(HttpStatus.OK);
	}


	
	
	
	
}
