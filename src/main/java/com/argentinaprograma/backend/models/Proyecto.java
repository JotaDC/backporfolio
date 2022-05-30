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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Javier
 */
@Getter @Setter
@Entity
public class Proyecto implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long idProyecto;
    private String nombreProyecto;
    private String fotoProyecto;
    private String linkProyecto;
    private String periodoProyecto;
    private String descProyecto;
}
