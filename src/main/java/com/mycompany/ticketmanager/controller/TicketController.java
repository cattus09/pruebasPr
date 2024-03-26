package com.mycompany.ticketmanager.controller;

import com.mycompany.ticketmanager.model.Ticket;
import com.mycompany.ticketmanager.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketRepository ticketRepository;

    @PostMapping("/crear")
    public void crearTicket(@RequestBody List<String> urls) {
        Ticket ticket = new Ticket();
        ticketRepository.save(ticket);
        // Aquí puedes implementar la lógica para procesar las URLs y guardar el ticket en la base de datos
    }

    @GetMapping("/todos")
    public List<Ticket> obtenerTodosLosTickets() {
        return ticketRepository.findAll();
    }

    @PutMapping("/aceptar/{id}")
    public void aceptarTicket(@PathVariable String id, @RequestBody Ticket ticket) {
        Ticket existingTicket = ticketRepository.findById(id).orElse(null);
        if (existingTicket != null) {
            existingTicket.setEstadoTicket(ticket.getEstadoTicket());
            existingTicket.setProveedor(ticket.getProveedor());
            existingTicket.setCorreoProveedor(ticket.getCorreoProveedor());
            existingTicket.setDueñoMarca(ticket.getDueñoMarca());
            ticketRepository.save(existingTicket);
            // Aquí puedes implementar la lógica para enviar el correo electrónico y actualizar el estado del ticket
        }
    }

    @PutMapping("/cerrar/{id}")
    public void cerrarTicket(@PathVariable String id) {
        Ticket existingTicket = ticketRepository.findById(id).orElse(null);
        if (existingTicket != null) {
            existingTicket.setEstadoTicket("cerrado");
            ticketRepository.save(existingTicket);
        }
    }
}
