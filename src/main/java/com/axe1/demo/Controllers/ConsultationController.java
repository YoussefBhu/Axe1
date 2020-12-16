package com.axe1.demo.Controllers;

import com.axe1.demo.Entities.Consultation;
import com.axe1.demo.Entities.User;
import com.axe1.demo.Repositories.ConsultationRepository;
import com.axe1.demo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/Consultations")
public class ConsultationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ConsultationRepository consultationRepository;

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public Consultation CreateConsultation(@RequestBody String sujet){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Consultation consultation = new Consultation();
        consultation.setPatient(userRepository.findByUserName(auth.getName()));
        consultation.setPsychologue(userRepository.ConsultationPsy());
        consultation.setDate(new Date());
        consultation.setActive(true);
        consultation.setChecked(false);
        //consultation.setChatLink("");  // Later
        consultation.setSujet(sujet);
        consultation.setNote("");
        return  consultationRepository.save(consultation);
    };

    @PutMapping
    @PreAuthorize("hasAnyRole('PSYCHOLOGUE','ADMIN')")
    public void ModifyConsultation(@RequestBody Consultation consultation){
        consultationRepository.save(consultation);
    }




}
