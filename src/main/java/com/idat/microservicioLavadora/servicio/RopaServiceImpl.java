package com.idat.microservicioLavadora.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.microservicioLavadora.modelo.Ropa;
import com.idat.microservicioLavadora.repository.RopaRepository;


@Service
public class RopaServiceImpl implements RopaService{

	@Autowired
	private RopaRepository repository;
	
	@Override
	public void guardarRopa(Ropa r) {
		
		r.setIdRopa(r.getIdRopa());
		r.setTipoRopa(r.getTipoRopa());
		r.setDescripcion(r.getDescripcion());
		repository.save(r);
	}
	
	@Override
	public void eliminarRopa(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}
	
	@Override
	public void editarRopa(Ropa r) {
		// TODO Auto-generated method stub
		repository.saveAndFlush(r);
	}

	@Override
	public List<Ropa> listarRopas() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	
	@Override
	public Ropa RopaById(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}
}
