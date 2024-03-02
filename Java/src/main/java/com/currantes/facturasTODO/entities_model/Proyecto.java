package com.currantes.facturasTODO.entities_model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data  //Anotación para generar automáticamente getters, setters y los toString

@JsonIgnoreProperties({ "tareas"}) //con esto solo se muestran

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
   // @JsonBackReference //pocho

    // RELACION TAREA
   // @JsonManagedReference

    @OneToMany(mappedBy = "proyecto", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Tarea> tareas =new ArrayList<>();

    {
        //IMPORTANTE: si yo comento el: mappedBy = "proyecto", Hibernate crear una tabla intermedia
        //llamada proyecto_tareas, que contiene el proecto_id y tarea_id

        /**
         * Cuando comentas la línea mappedBy = "proyecto" en la relación @OneToMany de la clase Proyecto,
         * Hibernate asume que debe crear una tabla intermedia para manejar la relación entre Proyecto y Tarea.
         * Esta tabla intermedia es necesaria cuando
         * la relación entre las dos entidades no se puede representar directamente en una de las tablas.
         * Al comentar la línea mappedBy = "proyecto",
         * estás indicando que no hay una propiedad en la clase Tarea que mapee directamente la relación con Proyecto.
         * Como resultado, Hibernate crea una tabla intermedia llamada proyecto_tareas para
         * mantener la relación entre las entidades.
         *
         * ESTO SOLO ES NECESARIO EN LAS RELACIONES DE MUCHOS A MUCHOS
         */

    } //Explicacion mappedBy




    //RELACION USER
    @ManyToOne
    @JoinColumn( name ="id_user",nullable = false)
    //@JsonIgnore // Esta anotación evita que el campo user se incluya en la serialización JSON
    private User user;

    //cascade = CascadeType.ALL: hace que las operaciones realizadas en proyecto se propaguen a sus tareas correspondientes
    //orphanRemoval = true: Elimina automáticamente las Tareas que ya no están asociadas a ningún Proyecto cuando se eliminan el proyecyo.
    //FetchType.LAZY
    public Proyecto() {
    }



}
