package com.idat.microservicioLavadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.microservicioLavadora.modelo.Ropa;


@Repository
public interface RopaRepository extends JpaRepository<Ropa,Integer> {

}
