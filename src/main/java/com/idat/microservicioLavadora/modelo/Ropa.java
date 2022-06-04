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
@Table(name = "ropa")
@Entity
public class Ropa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRopa;
	private String TipoRopa;
	private String descripcion;
	
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name="ropa_lavadora",
	joinColumns = @JoinColumn(name="id_ropa", 
	nullable = false, unique = true,
	foreignKey = @ForeignKey(foreignKeyDefinition 
			= "foreign key (id_ropa) references ropa (id_ropa)")),
	inverseJoinColumns =  @JoinColumn(name="id_lavadora", 
	nullable = false, unique = true,
	foreignKey = @ForeignKey(foreignKeyDefinition 
			= "foreign key (id_lavadora) references lavadora (id_lavadora)"))
	)
	
	private List<Lavadora> lavadora = new ArrayList<>();
	
	
	@ManyToMany(mappedBy = "ropa", cascade = 
		{CascadeType.PERSIST, CascadeType.MERGE})
	private List<Cliente> cliente = new ArrayList<>();
	
	public List<Lavadora> getLavadora() {
		return lavadora;
	}
	public void setLavadora(List<Lavadora> lavadora) {
		this.lavadora = lavadora;
	}
	public List<Cliente> getCliente() {
		return cliente;
	}
	public void setCliente(List<Cliente> cliente) {
		this.cliente = cliente;
	}
	
	
}
