package com.idat.microservicioLavadora.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.microservicioLavadora.modelo.Cliente;
import com.idat.microservicioLavadora.repository.ClienteRepository;

@Service
public class ClienteServiceImple implements ClienteService{

	@Autowired
	private ClienteRepository repository;
	
	
	@Override
	public void guardarCliente(Cliente p) {
		p.setIdCliente(p.getIdCliente());
		p.setNombreCliente(p.getNombreCliente());
		p.setApellidoCliente(p.getApellidoCliente());
		p.setNroCliente(p.getNroCliente());
		p.setDireccion(p.getDireccion());
		repository.save(p);
	}
	
	@Override
	public void eliminarCliente(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}
	
	@Override
	public void editarCliente(Cliente c) {
		// TODO Auto-generated method stub
		repository.saveAndFlush(c);
	}

	@Override
	public List<Cliente> listarClientes() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	
	@Override
	public Cliente ClienteById(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}
}
