package com.Eccomerce.eccomerceAPI.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity(name="endereco")
public class Endereco {
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String rua;
	private String Cep;
	private String Bairro;
	private String Cidade;
	private String Estado;
	private String Pais;
	private int Numero;
	

}
