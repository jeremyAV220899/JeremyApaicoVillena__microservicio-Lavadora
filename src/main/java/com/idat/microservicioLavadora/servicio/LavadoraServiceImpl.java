package com.idat.microservicioLavadora.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.microservicioLavadora.modelo.Lavadora;
import com.idat.microservicioLavadora.repository.LavadoraRepository;

@Service
public class LavadoraServiceImpl implements LavadoraService {

	@Autowired
	private LavadoraRepository repository;
	
	@Override
	public void guardarLavadora(Lavadora l) {
		
		l.setIdLavadora(l.getIdLavadora());
		l.setDescripcion(l.getDescripcion());
		l.setMarca(l.getMarca());
		l.setVoltaje(l.getVoltaje());
		repository.save(l);
	}
	
	@Override
	public void eliminarLavadora(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}
	
	@Override
	public void editarLavadora(Lavadora l) {
		// TODO Auto-generated method stub
		repository.saveAndFlush(l);
	}

	@Override
	public List<Lavadora> listarLavadoras() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	
	@Override
	public Lavadora LavadoraById(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}
}
