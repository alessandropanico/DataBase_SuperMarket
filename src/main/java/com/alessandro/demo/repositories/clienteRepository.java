package com.alessandro.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.alessandro.demo.entities.clienteEntity;

import jakarta.transaction.Transactional;

@Repository
public interface clienteRepository extends JpaRepository<clienteEntity, Long> {

	
	Optional<clienteEntity> findById(int id);
	
	List<clienteEntity> findByNome(String nome);
	
	List<clienteEntity> findByCognome(String cognome);
	
	List<clienteEntity> findByEmail(String email);
	
	
	//ELIMINAZIONE
	void deleteById(int id);
	
	
	//JOIN
	  // Definisci una query JPQL per ottenere i clienti con le relative vendite
    @Query("SELECT c, v FROM clienteEntity c JOIN venditeEntity v ON c.id = v.idcliente")
    List<Object[]> findClientiConVendite();
	
	
}
