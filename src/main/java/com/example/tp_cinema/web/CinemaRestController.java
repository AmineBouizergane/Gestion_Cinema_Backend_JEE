package com.example.tp_cinema.web;

import com.example.tp_cinema.DAO.FilmRepository;
import com.example.tp_cinema.DAO.TicketRepository;
import com.example.tp_cinema.entities.Film;
import com.example.tp_cinema.entities.Ticket;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.PrivateKey;
import java.util.List;
import java.util.ArrayList;


@RestController
@CrossOrigin("*") // Autorisation
public class CinemaRestController {
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private TicketRepository ticketRepository;

    @GetMapping(path="/imageFilm/{id}", produces= MediaType.IMAGE_JPEG_VALUE)
    public byte[] image(@PathVariable (name = "id")Long id) throws IOException {
        Film f = filmRepository.findById(id).get();
        String photoName= f.getPhoto();
        File file=new File(System.getProperty("user.home")+"/cinema/images/"+photoName);
        Path path= Paths.get(file.toURI());
        return Files.readAllBytes(path);
    }

    /*@PostMapping("/payerTickets")
    public List<Ticket> payerTickets(@ResponseBody TicketForm ticketForm){
        List<Ticket> lstTickets=new ArrayList<>();
        ticketForm.getTickets().forEach(idTickets->{
            Ticket ticket=ticketRepository.findById(idTickets).get();
            ticket.setReserve(true);
            ticket.setNomClient(ticketForm.getNomClient());
            ticketRepository.save(ticket);
            lstTickets.add(ticket);
        });
        return lstTickets;
    }*/
}

@Data
class TicketForm{
    private String nomClient;
    private List<Long> tickets=new ArrayList<>();
}