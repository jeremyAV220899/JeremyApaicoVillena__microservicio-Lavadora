package com.idat.microservicioLavadora.servicio;

import java.util.List;

import com.idat.microservicioLavadora.modelo.Lavadora;

public interface LavadoraService {

	public Lavadora LavadoraById(Integer id);

	public List<Lavadora> listarLavadoras();

	public void editarLavadora(Lavadora l);

	public void eliminarLavadora(Integer id);

	public void guardarLavadora(Lavadora l);

}
