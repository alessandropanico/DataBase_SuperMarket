package com.alessandro.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.alessandro.demo.entities.clienteEntity;
import com.alessandro.demo.entities.prodottoEntity;
import com.alessandro.demo.repositories.prodottoRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class prodottoService {
	
	private final prodottoRepository IPS;
	
	public prodottoService(prodottoRepository IPS) {
		this.IPS=IPS;
	}
	
	
	public List<prodottoEntity>getProdotti( ){
		return this.IPS.findAll();
	}
	
	
	public prodottoEntity aggiungiProdotto(prodottoEntity prodotto) {
		return this.IPS.save(prodotto);
	}
	
	
	public Optional<prodottoEntity> findById(int id){
		return this.IPS.findById(id);
	}
	
	public List<prodottoEntity> findByNome(String nome){
		return this.IPS.findByNome(nome);
	}
	

	public List<prodottoEntity> findByDescrizione(String descriizione){
		return this.IPS.findByDescrizione(descriizione);
	}
	
	
	@Transactional
	public void eliminaProdotto(int id) {
		 this.IPS.deleteById(id);
	}
	
	
	//MODIFICA
    public prodottoEntity updateProdotto(int id, prodottoEntity prodotto) {
        // Cerca il cliente con l'id specificato nel database o genera un'eccezione se non trovato
        prodottoEntity existingProdotto = this.IPS.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Prodotto non trovato con ID: " + id));

        // Effettua le modifiche al cliente esistente con i dati forniti
        existingProdotto.setNome(prodotto.getNome());
        existingProdotto.setDescrizione(prodotto.getDescrizione());

        // Salva le modifiche nel database
        return this.IPS.save(existingProdotto);
    }
	
	
    //JOIN
  

    public List<Object[]>getProdottoConDettagli(){
    	return this.IPS.findProdottoConDettaglio();
    }
    
    
    
    
    
}
