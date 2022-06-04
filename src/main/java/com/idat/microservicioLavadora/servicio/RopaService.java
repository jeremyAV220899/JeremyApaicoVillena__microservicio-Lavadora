package com.idat.microservicioLavadora.servicio;

import java.util.List;

import com.idat.microservicioLavadora.modelo.Ropa;

public interface RopaService {

	Ropa RopaById(Integer id);

	List<Ropa> listarRopas();

	void editarRopa(Ropa r);

	void eliminarRopa(Integer id);

	void guardarRopa(Ropa l);

}
