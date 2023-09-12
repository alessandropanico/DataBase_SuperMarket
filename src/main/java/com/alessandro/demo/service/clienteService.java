package com.alessandro.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.alessandro.demo.entities.clienteEntity;
import com.alessandro.demo.entities.venditeEntity;
import com.alessandro.demo.repositories.clienteRepository;
import com.alessandro.demo.repositories.venditeRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class clienteService {

	private final clienteRepository ICS;
	
	
	public clienteService(clienteRepository ICS) {
		this.ICS=ICS;
	}
	
	public List<clienteEntity> getClienti(){
		return this.ICS.findAll();
	}
	
	public clienteEntity aggiungiCliente(clienteEntity cliente) {
		return this.ICS.save(cliente);
	}
	
	public Optional<clienteEntity> findById(int id){
	    return ICS.findById(id);
	}
	
	public List<clienteEntity> findByNome(String nome){
		return this.ICS.findByNome(nome);
	}
	
	public List<clienteEntity> findByCognome(String cognome){
		return this.ICS.findByCognome(cognome);
	}
	
	public List<clienteEntity> findByEmail(String email){
		return this.ICS.findByEmail(email);
	}
	
    @Transactional
	public void EliminaCliente(int id) {
		this.ICS.deleteById(id);
	}
	
    //MODIFICA
    public clienteEntity updateCliente(int id, clienteEntity cliente) {
        // Cerca il cliente con l'id specificato nel database o genera un'eccezione se non trovato
        clienteEntity existingCliente = this.ICS.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente non trovato con ID: " + id));

        // Effettua le modifiche al cliente esistente con i dati forniti
        existingCliente.setNome(cliente.getNome());
        existingCliente.setCognome(cliente.getCognome());
        existingCliente.setEmail(cliente.getEmail());

        // Salva le modifiche nel database
        return this.ICS.save(existingCliente);
    }

    
    
    //JOIN
    public List<Object[]> getClientiConVendite() {
        return this.ICS.findClientiConVendite();
    }


}
