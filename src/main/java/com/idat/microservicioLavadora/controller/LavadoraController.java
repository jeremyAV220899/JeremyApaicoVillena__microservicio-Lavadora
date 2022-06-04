package com.idat.microservicioLavadora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idat.microservicioLavadora.modelo.Lavadora;
import com.idat.microservicioLavadora.servicio.LavadoraService;

@Controller
@RequestMapping("/lavadora/v1")
public class LavadoraController {

	@Autowired
	private LavadoraService service;
	
	@GetMapping(path = "/listar")
	public @ResponseBody List<Lavadora> listar(){
		return service.listarLavadoras();
	}
	
	@PostMapping(path = "/guardar")
	public @ResponseBody ResponseEntity<Lavadora> guardar(Lavadora l){
		service.guardarLavadora(l);
		return new ResponseEntity<Lavadora>(HttpStatus.CREATED);
	}
	
	@DeleteMapping(path = "/eliminar/{id}")
	public @ResponseBody ResponseEntity<Lavadora>  eliminar(Integer id){
		Lavadora lavadora = service.LavadoraById(id);
		if(lavadora !=null) {
			service.eliminarLavadora(id);
			return new ResponseEntity<Lavadora>(HttpStatus.OK);
		}
		return  new ResponseEntity<Lavadora>(HttpStatus.NOT_FOUND);
	}
	
    @PutMapping(path = "/editar")
    public @ResponseBody  ResponseEntity<Lavadora> editar (Lavadora l){
    	Lavadora lavadora = service.LavadoraById(l.getIdLavadora());
    	if(lavadora !=null) {
    		service.editarLavadora(lavadora);
    		return new ResponseEntity<Lavadora>(HttpStatus.OK);
    	}
    	return new ResponseEntity<Lavadora>(HttpStatus.NOT_FOUND);
    }
}
