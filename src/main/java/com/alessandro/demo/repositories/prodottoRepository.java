package com.alessandro.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.alessandro.demo.entities.prodottoEntity;

@Repository
public interface prodottoRepository extends JpaRepository<prodottoEntity, Long> {

	
		Optional<prodottoEntity> findById(int id);
	
		List<prodottoEntity> findByNome(String nome);
		
		List<prodottoEntity> findByDescrizione(String descrizione);
		
		
		
		//ELIMINAIZONE
		void deleteById(int id);
	
	  
		
	    @Query("SELECT p, dv FROM prodottoEntity p JOIN dettagliVenditaEntity dv ON p.id = dv.idprodotto")
	    List<Object[]> findProdottoConDettaglio();
}
