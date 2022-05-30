/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argentinaprograma.backend.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.argentinaprograma.backend.models.Proyecto;
import com.argentinaprograma.backend.services.ProyectoService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Javier
 */

@RestController
@RequestMapping("/proyecto")
public class ProyectoController {
      private final ProyectoService proyectoService;

    public ProyectoController(ProyectoService proyectoService) {
        this.proyectoService = proyectoService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Proyecto>> obtenerProyectos(){   
        List<Proyecto> proyectos= proyectoService.buscarProyectos();
        return new ResponseEntity<>(proyectos,HttpStatus.OK);
      
    }
    
    @PutMapping("/update")
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Proyecto> editarProyecto(@RequestBody Proyecto proyecto){
        Proyecto updateProyecto=proyectoService.editarProyecto(proyecto);
        return new ResponseEntity<>(updateProyecto,HttpStatus.OK);   
    }
    
    @PostMapping("/add")
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Proyecto> crearProyecto(@RequestBody Proyecto proyecto){
        Proyecto nuevaProyecto=proyectoService.agregarProyecto(proyecto);
        return new ResponseEntity<>(nuevaProyecto,HttpStatus.CREATED);
    }
    
    @DeleteMapping("delete/{id}")
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> borrarProyecto(@PathVariable("id") Long id){
        proyectoService.borrarProyecto(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping("/id/{id}")
    public ResponseEntity<Proyecto> obtenerProyecto(@PathVariable("id") Long id){   
        Proyecto proyecto=proyectoService.buscarProyectoPorId(id);
        return new ResponseEntity<>(proyecto,HttpStatus.OK);
      
    }
    
}
