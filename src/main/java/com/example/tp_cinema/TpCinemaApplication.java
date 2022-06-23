package com.example.tp_cinema;

import com.example.tp_cinema.entities.Film;
import com.example.tp_cinema.entities.Salle;
import com.example.tp_cinema.service.ICinemaInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class TpCinemaApplication implements CommandLineRunner {
    @Autowired
    private ICinemaInitService cinemaInitService;

    @Autowired
    private RepositoryRestConfiguration restConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(TpCinemaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        restConfiguration.exposeIdsFor(Film.class, Salle.class);
        cinemaInitService.initVille();
            cinemaInitService.initCinemas();
            cinemaInitService.initSalles();
            cinemaInitService.initPlaces();
            cinemaInitService.initSeances();
            cinemaInitService.initCategories();
            cinemaInitService.initFilms();
            cinemaInitService.initProjections();
            cinemaInitService.initTickets();
    }
}
