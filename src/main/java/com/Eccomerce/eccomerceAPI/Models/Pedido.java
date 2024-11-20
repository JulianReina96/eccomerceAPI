package com.Eccomerce.eccomerceAPI.Models;

import java.util.List;


import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToOne;

@Entity(name="pedido")
public class Pedido {
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	private Cliente cliente;	
	@ElementCollection	
	private List<Produto> produtos;
	@OneToOne
	private StatusPedido status;
	private double valorTotal;
	
	
	
}
