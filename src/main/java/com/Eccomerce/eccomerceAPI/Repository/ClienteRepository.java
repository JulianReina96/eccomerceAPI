package com.Eccomerce.eccomerceAPI.Repository;

import org.springframework.stereotype.Repository;

import com.Eccomerce.eccomerceAPI.Models.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	
	
	
}
