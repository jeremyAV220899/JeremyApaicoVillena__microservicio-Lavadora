package com.idat.microservicioLavadora.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "cliente")
@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCliente;
	private String nombreCliente;
	private String apellidoCliente;
	private String nroCliente;
	private String direccion;
	
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name="cliente_ropa",
	joinColumns = @JoinColumn(name="id_cliente", 
	nullable = false, unique = true,
	foreignKey = @ForeignKey(foreignKeyDefinition 
			= "foreign key (id_cliente) references cliente (id_cliente)")),
	inverseJoinColumns =  @JoinColumn(name="id_ropa", 
	nullable = false, unique = true,
	foreignKey = @ForeignKey(foreignKeyDefinition 
			= "foreign key (id_ropa) references ropa (id_ropa)"))
	)
	
	private List<Ropa> ropa = new ArrayList<>();

	public List<Ropa> getRopa() {
		return ropa;
	}
	
}
