/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.argentinaprograma.backend.repository;

import com.argentinaprograma.backend.models.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Javier
 */
public interface EducacionRepo extends JpaRepository<Educacion, Long>{
    
}
