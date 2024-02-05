package com.currantes.facturasTODO.entities_model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 300)
    private String nombre;
    @Column(nullable = false, length = 600)
    private String descripcion;
    @Column(nullable = true, length = 60)
    @Temporal(TemporalType.DATE) // para que no salga la hora UTC
    private Date fechaFinal;

    @Column(nullable = false, length = 60)
    private boolean estado;

    @ManyToOne
    @JoinColumn(name = "idProyecto", nullable = false)    //Especificación de la Columna de Clave Foránea:
    @JsonIgnore

    private Proyecto proyecto;

    public Tarea() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
