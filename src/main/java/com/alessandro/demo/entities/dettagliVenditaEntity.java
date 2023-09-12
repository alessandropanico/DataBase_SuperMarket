package com.alessandro.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="dettagli_vendite")
public class dettagliVenditaEntity {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="idvendita")
	private int idvendita;
	
	@Column(name="idprodotto")
	private int idprodotto;
	
	@Column(name="quantita")
	private int quantita;
	

	@ManyToOne
    @JoinColumn(name="idvendita",referencedColumnName = "id", insertable = false, updatable = false)
    private venditeEntity vendite;
	 
	
	@ManyToOne
    @JoinColumn(name="idprodotto",referencedColumnName = "id", insertable = false, updatable = false)
    private prodottoEntity prodotto;
	 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdvendita() {
		return idvendita;
	}
	public void setIdvendita(int idvendita) {
		this.idvendita = idvendita;
	}
	public int getIdprodotto() {
		return idprodotto;
	}
	public void setIdprodotto(int idprodotto) {
		this.idprodotto = idprodotto;
	}
	public int getQuantita() {
		return quantita;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	
	
}

	


