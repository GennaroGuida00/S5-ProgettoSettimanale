package com.example.gestionePrenotazioni.services;

import com.example.gestionePrenotazioni.entities.Edificio;
import com.example.gestionePrenotazioni.entities.Postazione;
import com.example.gestionePrenotazioni.repositories.EdificioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EdificioService {

    @Autowired
    EdificioRepository edificioRepository;

    public List<Edificio> getAllEdificii(){
        return edificioRepository.findAll();
    }

    public Edificio addEdificii(Edificio edificio){
        return edificioRepository.save(edificio);
    }
}
