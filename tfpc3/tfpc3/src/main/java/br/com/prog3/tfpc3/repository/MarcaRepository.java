package br.com.prog3.tfpc3.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.prog3.tfpc3.domain.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long>{
	
	
}
