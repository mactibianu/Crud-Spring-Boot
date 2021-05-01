package com.algaworks.crm.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.crm.model.Cliente;
import com.algaworks.crm.repository.ClienteRepository;



@RestController
@RequestMapping("/clientes")
public class ClienteController {

	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	} 		
	
	
	@GetMapping("/busca/{id}")
	public Cliente ListaUnico(@PathVariable(value="id")long id) {
		return clienteRepository.findById(id);
	}
	
	
	
	@PostMapping("/cadastro")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	
	}
	
	
	@DeleteMapping("/delete")
	public void deletaCliente(@RequestBody Cliente cliente) {
		clienteRepository.delete(cliente);
	}
		
	
	
	@PutMapping("/atualizar")
	public  Cliente atualizaCliente(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
}
		
		
		

