package com.currantes.facturasTODO.entities_model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data  //Anotación para generar automáticamente getters, setters y los toString

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
    private Date fecha_final;

    @Column(nullable = true, length = 60)
    @Temporal(TemporalType.DATE)
    private Date fecha_esperada;

    @Column(length = 600)
    private Boolean estado = false;


    @OneToMany(mappedBy = "proyecto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tarea> tareas =new ArrayList<>();

    //cascade = CascadeType.ALL: hace que las operaciones realizadas en proyecto se propaguen a sus tareas correspondientes
    //orphanRemoval = true: Elimina automáticamente las Tareas que ya no están asociadas a ningún Proyecto cuando se eliminan el proyecyo.

    public Proyecto() {
    }



}
