/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argentinaprograma.backend.services;


import com.argentinaprograma.backend.exception.UserNotFoundException;
import com.argentinaprograma.backend.models.Educacion;
import com.argentinaprograma.backend.models.Experiencia;
import com.argentinaprograma.backend.models.Skill;
import com.argentinaprograma.backend.repository.ExperienciaRepo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.argentinaprograma.backend.repository.SkillRepo;

/**
 *
 * @author Javier
 */
@Service
@Transactional
public class SkillService {
    private final SkillRepo skillRepo;
    
    @Autowired
    public SkillService(SkillRepo skillRepo){
        this.skillRepo=skillRepo;
    }
    
    public Skill agregarSkill(Skill skill){
        return skillRepo.save(skill);
    }
    
    public List<Skill> buscarSkill(){
        return this.skillRepo.findAll();
    }
    
    public Skill editarSkill(Skill skill){
        return skillRepo.save(skill);
    }
    
    public void borrarSkill(Long id){
        skillRepo.deleteById(id);
    }
     public Skill buscarSkillPorId(Long id){
        return skillRepo.findById(id).orElseThrow(()->new UserNotFoundException("skill no encontrado"));
        
        
        
    }
}
