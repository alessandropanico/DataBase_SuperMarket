package com.alessandro.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.alessandro.demo.entities.dettagliVenditaEntity;

@Repository
public interface dettagliVenditaRepository extends JpaRepository<dettagliVenditaEntity, Long> {

	
	Optional<dettagliVenditaEntity> findById(int id);
	
    List<dettagliVenditaEntity> findByIdvendita(int idvendita);
	
	List<dettagliVenditaEntity> findByIdprodotto(int idprodotto);
	
	
	//ELIMINAZIONE
	void deleteById(int id);
	
	



	
	
	
}
