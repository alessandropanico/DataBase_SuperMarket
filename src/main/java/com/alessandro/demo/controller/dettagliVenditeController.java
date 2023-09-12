package com.alessandro.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alessandro.demo.entities.clienteEntity;
import com.alessandro.demo.entities.dettagliVenditaEntity;
import com.alessandro.demo.service.dettagliVenditaService;

@RestController
@RequestMapping("/api/dettagliVendita")
public class dettagliVenditeController {
	
	private final dettagliVenditaService IVDS;
	
	public dettagliVenditeController(dettagliVenditaService IVDS) {
		 this.IVDS=IVDS;
	}
	
	
	@GetMapping("/provaVendita")
	public String prova() {
		return "dettagli vendita";
	}
	
	@GetMapping("/listaDettagliVendita")
		public List<dettagliVenditaEntity> getDettagliVendita(){
			return this.IVDS.getDettagliVendita();
		}
		
		
	@GetMapping("/byId/{id}")
	public Optional<dettagliVenditaEntity> ricercaPerId(@PathVariable int id){
		return this.IVDS.findById(id);
	}
		
	@GetMapping("/byIdVendita/{idvendita}")
	public List<dettagliVenditaEntity> ricercaPerIdVendita(@PathVariable int idvendita){
		return this.IVDS.findByVendita(idvendita);
	}
		

	
	@GetMapping("/byIdProdotto/{idprodotto}")
	public List<dettagliVenditaEntity> ricercaPerIdProdotto(@PathVariable int idprodotto){
		return this.IVDS.findByProdotto(idprodotto);
	}
	
	
	
	
	//AGGIUNTA
	@PostMapping("/aggiungiDettagliVendita")
	public ResponseEntity<String> aggiungiDettagliVendita(@RequestBody dettagliVenditaEntity dettagliVendita){
		try {
			dettagliVenditaEntity newDettagliVendita = IVDS.aggiungiDettagliVendita(dettagliVendita);
            return ResponseEntity.ok("Cliente aggiunto con successo con ID: "+newDettagliVendita.getId());
		}catch(Exception e) {
            return ResponseEntity.badRequest().body("Errore durante la creazione del cliente: " + e.getMessage());
		}
	}
		
		
	//MODIFICA
	@PutMapping("/modificaDettagliVendita/{id}")
	public dettagliVenditaEntity modificaDettagliVendita(@PathVariable int id, @RequestBody dettagliVenditaEntity dettagliVendita) {
		return this.IVDS.updateDettagliVendita(id, dettagliVendita);
	}
		
	
	@DeleteMapping("/eliminaDettagliVendita/{id}")
	public ResponseEntity<String> eliminaDettagliVendita(@PathVariable int id){
		this.IVDS.deleteById(id);
		return ResponseEntity.ok("Eliminazione riuscita");
	}

		
		
	  
	
	
}

	






