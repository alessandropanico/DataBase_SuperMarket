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
import com.alessandro.demo.service.clienteService;

@RestController
@RequestMapping("/api/cliente")
public class clienteController {
	
	
	private final clienteService ICS;
	
	
	public clienteController(clienteService ICS) {
		this.ICS=ICS;
	}
	
	
	@GetMapping("/prova")
	public String prova() {
		return "ciao";
	}
	
	
	@GetMapping("/listaClienti")
	public List<clienteEntity> getClienti(){
		return this.ICS.getClienti();
	}
	
	
	@PostMapping("/aggiungiCliente")
	public ResponseEntity<String> aggungiCliente(@RequestBody clienteEntity cliente){
		try {
			clienteEntity newCliente = ICS.aggiungiCliente(cliente);
            return ResponseEntity.ok("Cliente aggiunto con successo con ID: "+newCliente.getId());
		}catch (Exception e) {
            return ResponseEntity.badRequest().body("Errore durante la creazione del cliente: " + e.getMessage());
        }
	}
	
	
	//RICERCA PER ID
	@GetMapping("/byId/{id}")
	public Optional<clienteEntity> ricercaPerId(@PathVariable int id){
		return this.ICS.findById(id);
	}
	
	
	//RICERCA PER NOME
	@GetMapping("/byNome/{nome}")
	public List<clienteEntity> ricercaPerNome(@PathVariable String nome){
		return this.ICS.findByNome(nome);
		
	}
	
	//RICERCA PER COGNOME
	@GetMapping("/byCognome/{cognome}")
	public List<clienteEntity> ricercaPerCognome(@PathVariable String cognome){
		return this.ICS.findByCognome(cognome);
	}
	
	
	//RICERCA PER EMAIL
	@GetMapping("/byEmail/{email}")
	public List<clienteEntity> ricercaPerEmail(@PathVariable String email){
		return this.ICS.findByEmail(email);
	}
	
	
	//MODIFICA
	@PutMapping("/modificaCliente/{id}")
	public clienteEntity ModificaCliente(@PathVariable int id,@RequestBody clienteEntity cliente) {
		return this.ICS.updateCliente(id, cliente);
	}
	
	//ELIMINAIZIONE
	@DeleteMapping("/eliminaCliente/{id}")
	public ResponseEntity<String> deleteCliente(@PathVariable int id){
			this.ICS.EliminaCliente(id);
			return ResponseEntity.ok("Eliminazione riuscita");
	}
	
	
	//JOIN
	@GetMapping("/clientiConVendite")
    public List<Object[]> getClientiConVendite() {
        return this.ICS.getClientiConVendite();
    }
  
	
}
