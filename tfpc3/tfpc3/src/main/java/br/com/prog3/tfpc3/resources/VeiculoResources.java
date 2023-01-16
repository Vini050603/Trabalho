package br.com.prog3.tfpc3.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.prog3.tfpc3.domain.Veiculo;
import br.com.prog3.tfpc3.service.VeiculoService;

@RestController
@RequestMapping("/api/v1/tfpc3/veiculo")
@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")

public class VeiculoResources {
	@Autowired
	private VeiculoService veiculoService;
	
	@PostMapping
	public Veiculo save(@RequestBody Veiculo veiculo){
	return veiculoService.save(veiculo);
	}
	
	@GetMapping
	public ResponseEntity<List<Veiculo>> findAll(){
		List<Veiculo> veiculo = veiculoService.findAll();
		if(veiculo == null || veiculo.isEmpty()) {
			return new ResponseEntity<List<Veiculo>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Veiculo>>(veiculo, HttpStatus.OK);
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<?> findById(@PathVariable Long id){
		return veiculoService.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Veiculo> update(@PathVariable("id") Long id,@RequestBody Veiculo veiculo) {
		return veiculoService.findById(id)
				.map(record -> {
					record.setPlaca(veiculo.getPlaca());
					record.setCor(veiculo.getCor());
					record.setAnoModelo(veiculo.getAnoModelo());
					record.setMarca(veiculo.getMarca());
						Veiculo updated = veiculoService.save(record);
						return ResponseEntity.ok().body(updated);
					}).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping(path ={"/{id}"})
	public ResponseEntity<?> delete(@PathVariable Long id) {
	return veiculoService.findById(id)
	.map(record -> {
	veiculoService.deleteById(id);
	return ResponseEntity.ok().build();
	}).orElse(ResponseEntity.notFound().build());
	}
}
