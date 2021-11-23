package com.sofkau.fullstack.usuariosspringboot.services;

import com.sofkau.fullstack.usuariosspringboot.models.UsuarioModel;
import com.sofkau.fullstack.usuariosspringboot.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

// Indicamos que se va a crear un service
@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository; // Instanciamos el repositorio creado previamente

    // Definimos los metodos que harán las peticiones al repositorio

    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    public UsuarioModel guardarUsuario(UsuarioModel usuario){
        return usuarioRepository.save(usuario);
    }

    // Optional es en caso de que no encuentre un registro con ese ID, devuelve algo
    public Optional<UsuarioModel> obtenerPorId(Long id){
        return usuarioRepository.findById(id);
    }

    public ArrayList<UsuarioModel> obtenerPorPrioridad(Integer prioridad){
        return usuarioRepository.findByPrioridad(prioridad);
    }

    public boolean eliminarUsuario(Long id){
        try {
            usuarioRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
