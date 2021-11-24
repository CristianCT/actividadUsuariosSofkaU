package com.sofkau.fullstack.usuariosspringboot.models;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity // Indicar que se va a crear una entidad
@Table(name = "usuarios") // Anotación para indicar que se va a crear una tabla con un determinado nombre
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Anotación para que se pueda generar el ID automaticamente
    @Column(unique = true, nullable = false) // Anotación para indicar que el valor de la columna debe ser unico y no nulo
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private Integer prioridad;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }
}
