package br.com.prog3.tfpc3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prog3.tfpc3.domain.Marca;
import br.com.prog3.tfpc3.repository.MarcaRepository;

@Service
public class MarcaService {
	@Autowired
	private MarcaRepository marcaRepository;
	
	public Marca save(Marca marca) {
		return marcaRepository.save(marca);
	}
	public List<Marca> findAll(){
		return (List<Marca>) marcaRepository.findAll();
	}
	public Optional<Marca> findById(Long id) {
		return marcaRepository.findById(id);
	}
	public Marca update(Marca marca) {
		return marcaRepository.save(marca);
	}
	public void deleteById(Long id) {
			marcaRepository.deleteById(id);
	}
	
}
