package com.mycompany.ticketmanager.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "tickets")
public class Ticket {
    @Id
    private String id;
    private Date fechaCreacion;
    private String estadoTicket;
    private String proveedor;
    private String correoProveedor;
    private String dueñoMarca;

    public Ticket() {
        this.fechaCreacion = new Date();
    }

    // Getters y Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getEstadoTicket() {
        return estadoTicket;
    }

    public void setEstadoTicket(String estadoTicket) {
        this.estadoTicket = estadoTicket;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getCorreoProveedor() {
        return correoProveedor;
    }

    public void setCorreoProveedor(String correoProveedor) {
        this.correoProveedor = correoProveedor;
    }

    public String getDueñoMarca() {
        return dueñoMarca;
    }

    public void setDueñoMarca(String dueñoMarca) {
        this.dueñoMarca = dueñoMarca;
    }
}
