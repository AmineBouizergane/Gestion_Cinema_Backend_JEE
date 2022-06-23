package com.example.tp_cinema.entities;


import org.springframework.data.rest.core.config.Projection;
//import sun.security.krb5.internal.Ticket;

@Projection(name="ticketsProj",types=Ticket.class)
public interface TicketsProj {
    public Long getId();
    public String getNomClient();
    public double getPrix();
    public Integer getCodePayement();
    public boolean getReserve();
    public Place getPlace();
}
