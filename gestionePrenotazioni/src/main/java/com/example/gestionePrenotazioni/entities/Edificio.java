package com.example.gestionePrenotazioni.entities;

import com.example.gestionePrenotazioni.enums.Tipo_postazione;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "edificii")
public class Edificio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String nome;

    @Column
    private String indirizzo;

    @Column
    private String città;

    @OneToMany(mappedBy = "edificii")
    private List<Postazione> postazioni=new ArrayList<>();

    public Edificio(String nome, long id, String indirizzo, String città) {
        this.nome = nome;
        this.id = id;
        this.indirizzo = indirizzo;
        this.città = città;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getCittà() {
        return città;
    }

    public void setCittà(String città) {
        this.città = città;
    }

    @Override
    public String toString() {
        return "Edificio{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", città='" + città + '\'' +
                ", postazioni=" + postazioni +
                '}';
    }
}


