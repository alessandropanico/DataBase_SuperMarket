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
import com.alessandro.demo.entities.venditeEntity;
import com.alessandro.demo.service.venditeService;

@RestController
@RequestMapping("/api/vendite")
public class venditeController {
	
	private final venditeService IVS;
	
	public venditeController(venditeService IVS) {
		this.IVS=IVS;
	}
	
	
	@GetMapping("/provaVendite")
	public String prova() {
		return "prova vendita";
	}
	
	
	@GetMapping("/listaVendite")
	public List<venditeEntity>listaVendite()
	{
		return this.IVS.getVendite();
	}
	
	@GetMapping("/byId/{id}")
	public Optional<venditeEntity>ricercaPerId(@PathVariable int id){
		return this.IVS.findById(id);
	}
	
	
	@GetMapping("/byCodice/{codice}")
	public List<venditeEntity> ricercaPerCodice(@PathVariable int codice){
		return this.IVS.findByCodice(codice);
	}
	
	
	@GetMapping("/byData/{data}")
	public List<venditeEntity> ricercaPerData(@PathVariable String data){
		return this.IVS.findByData(data);
	}
	
	
	@GetMapping("/byIdCliente/{idcliente}")
	public List<venditeEntity> ricercaPerCliente(@PathVariable int idcliente){
		return this.IVS.findByIdcliente(idcliente);
	}
	
	
	@PostMapping("/aggiungiVendita")
	public ResponseEntity<String>aggingiVendita(@RequestBody venditeEntity vendita){
		try {
			venditeEntity newVendite= IVS.aggiungiVendita(vendita);
			return ResponseEntity.ok("Informazioni aggiunte con successo con ID "+newVendite.getId());
		}catch(Exception e) {
			return ResponseEntity.badRequest().body("Errore durante la creazione della vendita: "+e.getMessage());
		}
		
	}
	
	
	//MODIFICA
	@PutMapping("/modificaVendita/{id}")
	public venditeEntity updateVendita(@PathVariable int id, @RequestBody venditeEntity vendita){
		return this.IVS.updateVendite(id, vendita);
		
	}
	
	
	//ELIMINAZIONE
	@DeleteMapping("/eliminaVendita/{id}")
	public ResponseEntity<String> eliminaVendita(@PathVariable int id) {
		this.IVS.deleteById(id);
		return ResponseEntity.ok("Eliminazione effettuata con successo");
	}
	
  

	//JOIN
  
    @GetMapping("/venditeConDettagli")
    public List<Object[]> getVenditeConDettagli() {
        return this.IVS.getVenditeConDettagliVendite();
    }


	
	
	
	
	
	

}
