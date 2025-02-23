package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.demo.entity.Estudante;

public class EstudanteService {
	
	private static Map<Long, Estudante> listaEstudantes = new HashMap<>();
	
	private ResponseEntity<Estudante> buscarEstudantePorId(Long id) {
		Estudante estudante = listaEstudantes.get(id);
		if (estudante == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(estudante);
	}
	
	private List<Estudante> buscarTodosEstudantes(){
		return new ArrayList<> (listaEstudantes.values());
	}	
	
	private ResponseEntity<Estudante> cadastrarEstudante (Estudante estudante) {
		
		Estudante estudanteEncontrado = listaEstudantes.get(estudante.getId());
		if (estudanteEncontrado == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(estudanteEncontrado);
	
	}
}
