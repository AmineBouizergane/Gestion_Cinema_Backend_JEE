package com.example.tp_cinema.DAO;

import com.example.tp_cinema.entities.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")
public interface VilleRepository extends JpaRepository<Ville,Long> {
}
