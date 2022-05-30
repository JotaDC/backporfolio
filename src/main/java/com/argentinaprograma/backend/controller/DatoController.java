/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argentinaprograma.backend.controller;


import com.argentinaprograma.backend.models.Dato;
import com.argentinaprograma.backend.services.DatoService;
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
@RequestMapping("/dato")
public class DatoController {
    private final DatoService datoService;

    public DatoController(DatoService datoService) {
        this.datoService = datoService;
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Dato> obtenerDato(@PathVariable("id") Long id){   
        Dato dato=datoService.buscarDatoPorId(id);
        return new ResponseEntity<>(dato,HttpStatus.OK);
      
    }
    
    @PutMapping("/update")
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Dato> editarDato(@RequestBody Dato dato){
        Dato updateDato=datoService.editarDato(dato);
        return new ResponseEntity<>(updateDato,HttpStatus.OK);   
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<Dato>> obtenerUsarios(){   
        List<Dato> datos= datoService.buscarDatos();
        return new ResponseEntity<>(datos,HttpStatus.OK);
      
    }
           
    @PostMapping("/add")
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Dato> crearDato(@RequestBody Dato datos){
        Dato nuevaDatos=datoService.agregarDato(datos);
        return new ResponseEntity<>(nuevaDatos,HttpStatus.CREATED);
    }
    
    
    @DeleteMapping("delete/{id}")
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> borrarDato(@PathVariable("id") Long id){
        datoService.borrarDato(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
   
    
    
    
}
