package com.idat.microservicioLavadora.servicio;

import java.util.List;

import com.idat.microservicioLavadora.modelo.Cliente;

public interface ClienteService {

	public List<Cliente> listarClientes();

	public Cliente ClienteById(Integer id);

	public void editarCliente(Cliente c);

	public void eliminarCliente(Integer id);

	public void guardarCliente(Cliente p);

}
