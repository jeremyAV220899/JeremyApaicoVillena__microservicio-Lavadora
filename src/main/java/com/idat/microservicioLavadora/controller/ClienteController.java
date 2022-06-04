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

import com.idat.microservicioLavadora.modelo.Cliente;
import com.idat.microservicioLavadora.servicio.ClienteService;

@Controller
@RequestMapping("/cliente/v1")
public class ClienteController {

	@Autowired
	private ClienteService service;
	
	@GetMapping(path = "/listar")
	public @ResponseBody List<Cliente> listar(){
		return service.listarClientes();
	}
	
	@PostMapping(path = "/guardar")
	public @ResponseBody ResponseEntity<Cliente> guardar(Cliente c){
		service.guardarCliente(c);
		return new ResponseEntity<Cliente>(HttpStatus.CREATED);
	}
	
	@DeleteMapping(path = "/eliminar/{id}")
	public @ResponseBody ResponseEntity<Cliente>  eliminar(Integer id){
		Cliente cliente = service.ClienteById(id);
		if(cliente !=null) {
			service.eliminarCliente(id);
			return new ResponseEntity<Cliente>(HttpStatus.OK);
		}
		return  new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
	}
	
    @PutMapping(path = "/editar")
    public @ResponseBody  ResponseEntity<Cliente> editar (Cliente c){
    	Cliente cliente = service.ClienteById(c.getIdCliente());
    	if(cliente !=null) {
    		service.editarCliente(cliente);
    		return new ResponseEntity<Cliente>(HttpStatus.OK);
    	}
    	return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
    }
}
