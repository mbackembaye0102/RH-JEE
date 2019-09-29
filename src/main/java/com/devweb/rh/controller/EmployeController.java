package com.devweb.rh.controller;

import com.devweb.rh.model.Employe;
import com.devweb.rh.model.Service;
import com.devweb.rh.repository.EmployeRepository;
import com.devweb.rh.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/employe")

public class EmployeController {
    @Autowired
    private EmployeRepository employeRepository;
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/liste")
    public List<Employe> liste (){
        return employeRepository.findAll();
    }


    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping(value = "/addEmploye",consumes =(MediaType.APPLICATION_JSON_VALUE))
    public Employe add (@RequestBody(required = false) Employe e){
        Service service = null;
        e.setService(service);
        return employeRepository.save(e);
    }

}
