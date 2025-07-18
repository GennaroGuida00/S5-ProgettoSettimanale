package com.example.gestionePrenotazioni.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "prenotazioni")

public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "utente_id", nullable = false)
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "postazione_id", nullable = false)
    private Postazione postazione;

    public Prenotazione(LocalDate data, Utente utente, Postazione postazione) {
        this.data = data;
        this.utente = utente;
        this.postazione = postazione;
    }

    public Prenotazione() {
    }

    public long getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Prenotazione{" +
                "id=" + id +
                ", data=" + data +
                ", utente=" + utente +
                ", postazione=" + postazione +
                '}';
    }
}
