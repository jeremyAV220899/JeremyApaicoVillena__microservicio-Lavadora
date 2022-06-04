package com.idat.microservicioLavadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.microservicioLavadora.modelo.Lavadora;


@Repository
public interface LavadoraRepository extends JpaRepository<Lavadora,Integer> {

}
