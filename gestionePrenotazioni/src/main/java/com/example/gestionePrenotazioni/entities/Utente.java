package com.example.gestionePrenotazioni.entities;

import com.example.gestionePrenotazioni.enums.Tipo_postazione;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "utenti")
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String username;

    @Column
    private String nomecompleto;

    @Column
    private String email;

    @OneToMany(mappedBy = "utente")
    private List<Prenotazione> prenotazioni;

    public Utente(String username, String nomecompleto, String email) {
        this.username = username;
        this.nomecompleto = nomecompleto;
        this.email = email;
    }

    public Utente() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNomecompleto() {
        return nomecompleto;
    }

    public void setNomecompleto(String nomecompleto) {
        this.nomecompleto = nomecompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", nomecompleto='" + nomecompleto + '\'' +
                ", email='" + email + '\'' +
                ", prenotazioni=" + prenotazioni +
                '}';
    }
}
