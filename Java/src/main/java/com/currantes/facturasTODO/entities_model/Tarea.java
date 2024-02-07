package com.currantes.facturasTODO.entities_model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Tarea {
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

    @Column(nullable = false, length = 60)
    private boolean estado;

    @ManyToOne
    @JoinColumn(name = "id_proyecto", nullable = false)    //Especificación de la Columna de Clave Foránea:

    private Proyecto proyecto;

    public Tarea() {
    }

}
