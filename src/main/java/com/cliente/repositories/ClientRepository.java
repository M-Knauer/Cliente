package com.cliente.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cliente.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
