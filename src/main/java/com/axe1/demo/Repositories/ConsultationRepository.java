package com.axe1.demo.Repositories;

import com.axe1.demo.Entities.Consultation;
import com.axe1.demo.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
