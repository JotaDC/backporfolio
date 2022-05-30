/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argentinaprograma.backend.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Javier
 */
@Getter @Setter
@Entity
public class Dato implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(nullable=false, updatable=false)
    private Long id;
    private String nombre;
    private String apellido;
    private String titulo;
    private String descripcion;
    private String fotoPerfil;
    private String fotoFondo;
    /*
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "idEdu" )
    private List<Educacion> educacionList;
    
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "idExp" )
    private List<Experiencia> experienciaList;
    
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "idSkill" )
    private List<Skill> skillList;
    
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "idProyecto" )
    private List<Proyecto> proyectoList;
    */
}
