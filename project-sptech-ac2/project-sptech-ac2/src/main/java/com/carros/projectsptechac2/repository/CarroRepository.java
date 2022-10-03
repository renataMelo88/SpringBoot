package com.carros.projectsptechac2.repository;


import com.carros.projectsptechac2.dominio.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends
        JpaRepository<Carro, Integer> {
}