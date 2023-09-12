package com.alessandro.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.alessandro.demo.entities.clienteEntity;
import com.alessandro.demo.entities.dettagliVenditaEntity;
import com.alessandro.demo.repositories.dettagliVenditaRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class dettagliVenditaService {
	
	private final dettagliVenditaRepository IVDS;
	
	public dettagliVenditaService(dettagliVenditaRepository IVDS)
	{
		this.IVDS=IVDS;
	}

	
	public List<dettagliVenditaEntity> getDettagliVendita(){
		return this.IVDS.findAll();
	}
	
	public dettagliVenditaEntity aggiungiDettagliVendita(dettagliVenditaEntity dettagliVendita) {
		return this.IVDS.save(dettagliVendita);
	}
	
	public Optional<dettagliVenditaEntity> findById(int id){
		return this.IVDS.findById(id);
	}
	
	
	public List<dettagliVenditaEntity> findByVendita(int idvendita){
		return this.IVDS.findByIdvendita(idvendita);
	}
	
	
	public List<dettagliVenditaEntity> findByProdotto(int idprodotto){
		return this.IVDS.findByIdprodotto(idprodotto);
	}
	
	
	//ELIMINAZIONE
	@Transactional
	public void deleteById(int id) {
		this.IVDS.deleteById(id);
	}
	
	
	//MODIFICA
    public dettagliVenditaEntity updateDettagliVendita(int id, dettagliVenditaEntity dettaglio) {
        // Cerca il cliente con l'id specificato nel database o genera un'eccezione se non trovato
    	dettagliVenditaEntity dettagliExsisting = this.IVDS.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Dettaglio vendita non trovato con ID: " + id));

        // Effettua le modifiche al cliente esistente con i dati forniti
    	dettagliExsisting.setIdprodotto(dettaglio.getIdprodotto());
    	dettagliExsisting.setIdvendita(dettaglio.getIdvendita());
    	dettagliExsisting.setQuantita(dettaglio.getQuantita());

        // Salva le modifiche nel database
        return this.IVDS.save(dettagliExsisting);
    }

	
    
    //JOIN
    
  
  
}
