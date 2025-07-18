package com.example.gestionePrenotazioni.services;

import com.example.gestionePrenotazioni.entities.Utente;
import com.example.gestionePrenotazioni.exceptions.NotFoundException;
import com.example.gestionePrenotazioni.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtenteService {

    @Autowired
    UtenteRepository utenteRepository;

    public List<Utente> getAllUtenti(){
        return utenteRepository.findAll();
    }
    public Utente findById(long id){
        return utenteRepository.findById(id).orElseThrow(()->new NotFoundException(id));
    }

    public Utente addUtenti(Utente utente){
        return utenteRepository.save(utente);
    }
}
