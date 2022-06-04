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

import com.idat.microservicioLavadora.modelo.Ropa;
import com.idat.microservicioLavadora.servicio.RopaService;

@Controller
@RequestMapping("/ropa/v1")
public class RopaController {

	@Autowired
	private RopaService service;
	
	@GetMapping(path = "/listar")
	public @ResponseBody List<Ropa> listar(){
		return service.listarRopas();
	}
	
	@PostMapping(path = "/guardar")
	public @ResponseBody ResponseEntity<Ropa> guardar(Ropa r){
		service.guardarRopa(r);
		return new ResponseEntity<Ropa>(HttpStatus.CREATED);
	}
	
	@DeleteMapping(path = "/eliminar/{id}")
	public @ResponseBody ResponseEntity<Ropa>  eliminar(Integer id){
		Ropa ropa = service.RopaById(id);
		if(ropa !=null) {
			service.eliminarRopa(id);
			return new ResponseEntity<Ropa>(HttpStatus.OK);
		}
		return  new ResponseEntity<Ropa>(HttpStatus.NOT_FOUND);
	}
	
    @PutMapping(path = "/editar")
    public @ResponseBody  ResponseEntity<Ropa> editar (Ropa p){
    	Ropa ropa = service.RopaById(p.getIdRopa());
    	if(ropa !=null) {
    		service.editarRopa(ropa);
    		return new ResponseEntity<Ropa>(HttpStatus.OK);
    	}
    	return new ResponseEntity<Ropa>(HttpStatus.NOT_FOUND);
    }
}
