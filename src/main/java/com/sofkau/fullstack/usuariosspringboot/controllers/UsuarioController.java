package com.sofkau.fullstack.usuariosspringboot.controllers;

import com.sofkau.fullstack.usuariosspringboot.models.UsuarioModel;
import com.sofkau.fullstack.usuariosspringboot.services.UsuarioService;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/usuario") // Definimos la ruta que va a llamar al controlador
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService; // Instanciamos el service

    // Definimos los metodos que se van a ejecutar al realizar las peticiones HTTP con

    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    @PostMapping
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){
        try{
            return usuarioService.guardarUsuario(usuario);
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error al digitar los datos", e);
        }
    }

    @PutMapping("/{id}")
    public UsuarioModel actualizarUsuario(@PathVariable("id") Long id, @RequestBody UsuarioModel usuario){
        try{
            return usuarioService.actualizarUsuario(id, usuario);
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error al digitar los datos", e);
        }
    }

    @GetMapping( path = "/{id}")
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id){
        return usuarioService.obtenerPorId(id);
    }

    @GetMapping( path = "/query")
    public ArrayList<UsuarioModel> obtenerUsuariosPorPrioridad(@RequestParam("prioridad") Integer prioridad){
        return usuarioService.obtenerPorPrioridad(prioridad);

    }

    @DeleteMapping("/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean isDeleted = usuarioService.eliminarUsuario(id);
        if(isDeleted){
            return "Se eliminó el usuario con ID: " + id;
        } else {
            return "No se pudo eliminar el usuario con ID: " + id;
        }
    }
}
