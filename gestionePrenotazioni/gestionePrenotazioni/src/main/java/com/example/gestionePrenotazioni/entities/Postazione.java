package com.example.gestionePrenotazioni.entities;


import com.example.gestionePrenotazioni.enums.Tipo_postazione;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "postazioni")
public class Postazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String descrizione;

    @Column
    @Enumerated(EnumType.STRING)
    private Tipo_postazione tipo;

    @Column
    private int capienza;

    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;

    @OneToMany(mappedBy = "postazione")
    private List<Prenotazione> prenotazioni;

    public Postazione(String descrizione, Tipo_postazione tipo, int capienza, Edificio edificio) {
        this.descrizione = descrizione;
        this.tipo = tipo;
        this.capienza = capienza;
        this.edificio = edificio;
    }

    public Postazione() {
    }

    public long getId() {
        return id;
    }


    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Tipo_postazione getTipo() {
        return tipo;
    }

    public void setTipo(Tipo_postazione tipo) {
        this.tipo = tipo;
    }

    public int getCapienza() {
        return capienza;
    }

    public void setCapienza(int capienza) {
        this.capienza = capienza;
    }

    @Override
    public String toString() {
        return "Postazione{" +
                "id=" + id +
                ", descrizione='" + descrizione + '\'' +
                ", tipo=" + tipo +
                ", capienza=" + capienza +
                ", edificio=" + edificio +
                '}';
    }
}
