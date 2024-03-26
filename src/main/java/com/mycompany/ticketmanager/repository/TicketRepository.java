package com.mycompany.ticketmanager.repository;

import com.mycompany.ticketmanager.model.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TicketRepository extends MongoRepository<Ticket, String> {
}
