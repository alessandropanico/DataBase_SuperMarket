package com.alessandro.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.alessandro.demo.entities.venditeEntity;
import com.alessandro.demo.repositories.venditeRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class venditeService {
	
	private final venditeRepository IVS;
	
	public venditeService(venditeRepository IVS) {
		this.IVS=IVS;
	}

	public List<venditeEntity> getVendite(){
		return this.IVS.findAll();
	}
	
	public Optional<venditeEntity> findById(int id){
		return this.IVS.findById(id);
	}
	
	public List<venditeEntity> findByCodice(int codice){
		return this.IVS.findByCodice(codice);
	}
	
	
	public List<venditeEntity> findByData(String data){
		return this.IVS.findByData(data);
	}
	
	
	public List<venditeEntity> findByIdcliente(int idcliente){
		return this.IVS.findByIdcliente(idcliente);
	}
	
	
	public venditeEntity aggiungiVendita(venditeEntity vendita){
		return this.IVS.save(vendita);
	}
	
	
	//ELIMINAZIONE
	@Transactional
	public void deleteById(int id) {
		 this.IVS.deleteById(id);
	}
	
	
	//MODIFICA
	public venditeEntity updateVendite(int id, venditeEntity vendite) {
		venditeEntity venditeExsisting = this.IVS.findById(id).orElseThrow(() 
				-> new EntityNotFoundException("Vendita non trovata con ID: " + id));
		
		venditeExsisting.setCodice(vendite.getCodice());
		venditeExsisting.setData(vendite.getData());
		venditeExsisting.setIdcliente(vendite.getIdcliente());

		return this.IVS.save(venditeExsisting);
		
	}
	
	

	  public List<Object[]> getVenditeConDettagliVendite() {
		    return this.IVS.findVenditeConDettagli();
		}

	
	
	
}
