/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argentinaprograma.backend.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Javier
 */
@Getter @Setter
@Entity
public class Experiencia implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long idExp;
    private String empresaExp;
    private String periodoExp;
    private String puestoExp;
    private String descExp;
    private String imagenExp;
    
}
