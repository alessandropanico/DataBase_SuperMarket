package com.alessandro.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.alessandro.demo.entities.venditeEntity;

@Repository
public interface venditeRepository extends JpaRepository<venditeEntity, Long>{

	
	Optional<venditeEntity> findById(int id);
	
	List<venditeEntity> findByCodice(int codice);
	
	List<venditeEntity> findByData(String data);
	
	List<venditeEntity> findByIdcliente(int idcliente);
	
	
	void deleteById(int id);

	

	
	    @Query("SELECT v, dv FROM venditeEntity v JOIN dettagliVenditaEntity dv ON v.id = dv.idvendita")
	    List<Object[]> findVenditeConDettagli();


	


	
	
	
}
