package com.currantes.facturasTODO.entities_model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 300)
    private String nombre;
    @Column(nullable = true, length = 600)
    private String descripcion;

    @Column(nullable = true, length = 60)
    @Temporal(TemporalType.DATE) // para que no salga la hora UTC
    private Date fechaFinal;

    @Column(length = 600)
    private Boolean estado = false;


    @OneToMany(mappedBy = "proyecto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tarea> tareas =new ArrayList<>();

    //cascade = CascadeType.ALL: hace que las operaciones realizadas en proyecto se propaguen a sus tareas correspondientes
    //orphanRemoval = true: Elimina automáticamente las Tareas que ya no están asociadas a ningún Proyecto cuando se eliminan el proyecyo.

    public Proyecto() {
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

    public List<Tarea> getTareas() {
        return tareas;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

}
