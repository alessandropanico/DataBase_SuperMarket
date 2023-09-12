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

import com.alessandro.demo.entities.prodottoEntity;
import com.alessandro.demo.service.prodottoService;

@RestController
@RequestMapping("/api/prodotto")
public class prodottoController {

	private final prodottoService IPS;
	
	public prodottoController(prodottoService IPS) {
		this.IPS=IPS;
	}
	
	
	@GetMapping("/provaProdotto")
	public String prova() {
		return "prodotto";
	}
	
	@GetMapping("/listaProdotti")
	public List<prodottoEntity> getProdotti(){
		return this.IPS.getProdotti();
	}
	
	
	@PostMapping("/aggiungiProdotto")
		public ResponseEntity<String>aggiungiProdotto(@RequestBody prodottoEntity prodotto){
		try {
			prodottoEntity newProdotto = IPS.aggiungiProdotto(prodotto);
            return ResponseEntity.ok("Prodotto aggiunto con successo con ID: "+newProdotto.getId());
		}catch(Exception e){
            return ResponseEntity.badRequest().body("Errore durante la creazione del prodotto: " + e.getMessage());
		}

	}
	
	@GetMapping("/byId/{id}")
	public Optional<prodottoEntity> ricercaPerId(@PathVariable int id){
		return this.IPS.findById(id);
	}
	
	
	@GetMapping("/byNome/{nome}")
	public List<prodottoEntity>ricercaPerNome(@PathVariable String nome){
		return this.IPS.findByNome(nome);
		}
	
	
	@GetMapping("/byDescrizione/{descrizione}")
	public List<prodottoEntity> ricercaPerDescrizione(@PathVariable String descrizione){
		return this.IPS.findByDescrizione(descrizione);
	}
	
	
	
	//MODIFICA
	@PutMapping("/modificaProdotto/{id}")
	public prodottoEntity modificaProdotto(@PathVariable int id, @RequestBody prodottoEntity prodotto) {
		return this.IPS.updateProdotto(id, prodotto);
	}
	
	
	//ELIMINAZIONE
	@DeleteMapping("/eliminaProdotto/{id}")
	public ResponseEntity<String> eliminaProdotto(@PathVariable int id) {
		 this.IPS.eliminaProdotto(id);
		 return ResponseEntity.ok("Prodotto eliminato con successo!");
		
	}
	
	
	//JOIN
	@GetMapping("/prodottoConDettaglio")
    public List<Object[]> getProdottoConDettaglio() {
        return this.IPS.getProdottoConDettagli();
    }
  
	
	
	
	
}
