package com.example.gestionePrenotazioni.runners;

import com.example.gestionePrenotazioni.entities.Edificio;
import com.example.gestionePrenotazioni.entities.Postazione;
import com.example.gestionePrenotazioni.enums.Tipo_postazione;
import com.example.gestionePrenotazioni.services.EdificioService;
import com.example.gestionePrenotazioni.services.PostazioneService;
import com.example.gestionePrenotazioni.services.PrenotazioneService;
import com.example.gestionePrenotazioni.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PrenotazioniRunners implements CommandLineRunner {

    @Autowired
    EdificioService edificioService;

    @Autowired
    PostazioneService postazioneService;

    @Autowired
    PrenotazioneService prenotazioneService;

    @Autowired
    UtenteService utenteService;




    @Override
    public void run(String... args) throws Exception {

        Edificio edificio1 = new Edificio("Edificio Centrale", "Via Roma 1", "Milano");
        Edificio edificio2 = new Edificio("Edificio Est", "Via Verdi 22", "Torino");
        Edificio edificio3 = new Edificio("Torre Ovest", "Piazza Garibaldi 5", "Napoli");
        Edificio edificio4 = new Edificio("Palazzo Nord", "Viale Europa 10", "Bologna");
        Edificio edificio5 = new Edificio("Campus Sud", "Via Manzoni 3", "Firenze");

        Postazione p1 = new Postazione("Postazione A", Tipo_postazione.OPENSPACE, 10, edificio1);
        Postazione p2 = new Postazione("Postazione B", Tipo_postazione.PRIVATO, 2, edificio1);
        Postazione p3 = new Postazione("Postazione C", Tipo_postazione.SALARIUNIONI, 6, edificio2);
        Postazione p4 = new Postazione("Postazione D", Tipo_postazione.OPENSPACE, 8, edificio3);
        Postazione p5 = new Postazione("Postazione E", Tipo_postazione.PRIVATO, 1, edificio4);

        edificioService.addEdificii(edificio1);
        edificioService.addEdificii(edificio2);
        edificioService.addEdificii(edificio3);
        edificioService.addEdificii(edificio4);
        edificioService.addEdificii(edificio5);

        postazioneService.addPostazioni(p1);
        postazioneService.addPostazioni(p2);
        postazioneService.addPostazioni(p3);
        postazioneService.addPostazioni(p4);
        postazioneService.addPostazioni(p5);

    }
}
