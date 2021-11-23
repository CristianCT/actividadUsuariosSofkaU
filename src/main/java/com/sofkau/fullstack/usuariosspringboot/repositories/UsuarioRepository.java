package com.sofkau.fullstack.usuariosspringboot.repositories;

import com.sofkau.fullstack.usuariosspringboot.models.UsuarioModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

// Definimos el repositorio de metodos que van a comunicar la base de datos, con nuestra APP
@Repository
// Definimos la interface que va a contener los metodos que va a heredar de la clase CrudRepository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {
    public abstract ArrayList<UsuarioModel> findByPrioridad(Integer prioridad);
}
