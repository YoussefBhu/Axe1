package com.axe1.demo;

import com.axe1.demo.Entities.Consultation;
import com.axe1.demo.Entities.Role;
import com.axe1.demo.Entities.User;
import com.axe1.demo.Repositories.ConsultationRepository;
import com.axe1.demo.Repositories.RoleRepository;
import com.axe1.demo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@SpringBootApplication
public class Axe1Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Axe1Application.class, args);
    }

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ConsultationRepository consultationRepository;

    @Override
    public void run(String... args) throws Exception {
/*
        Role Admin = new Role("ADMIN");
        Role Psychologue = new Role("PSYCHOLOGUE") ;
        Role User = new Role("USER");

        roleRepository.save(Admin);
        roleRepository.save(Psychologue);
        roleRepository.save(User);

        Collection<Role> roles = new ArrayList<Role>();
        roles.add(Admin);
        roles.add(Psychologue);
        roles.add(User);

        Collection<Role> roles2 = new ArrayList<Role>();
        roles2.add(User);

        User a = new User("Admin" ,new BCryptPasswordEncoder().encode("1234") ,"Admin" , "Admin" ,"Admin@", "06666" , "2020" , "Admin", true );
        User b = new User("User" ,new BCryptPasswordEncoder().encode("1234") ,"user" , "user" ,"user@", "06666" , "2020" , "Eleve", true );
        User c = new User("Psychologue" ,new BCryptPasswordEncoder().encode("1234") ,"psychologue" , "psychologue" ,"psychologue@", "0666" , "2020" , "psychologue", true );
        a.getRoles().add(Admin);
        a.getRoles().add(User);
        a.getRoles().add(Psychologue);

        b.getRoles().add(User);

        c.getRoles().add(Psychologue);

        userRepository.save(a);
        userRepository.save(b);
        userRepository.save(c);

*/
        //User c = new User("Psychologue1" ,new BCryptPasswordEncoder().encode("1234") ,"psychologue" , "psychologue" ,"psychologue1@", "0666" , "2020" , "psychologue", true );
       // c.getRoles().add(roleRepository.findByName("PSYCHOLOGUE"));
     //   userRepository.save(c);
      /*  List<User> pts = userRepository.findPsychologues();
        System.out.println(pts.size());
        List<User> users = userRepository.findUsers();
        System.out.println(users.size());
        consultationRepository.save(new Consultation(0,users.get(0),pts.get(0),"consultation 1","Link1",true,false,""));
        consultationRepository.save(new Consultation(1,users.get(1),pts.get(1),"consultation 2","Link2",true,false,""));
        consultationRepository.save(new Consultation(2,users.get(1),pts.get(0),"consultation 3","Link3",true,false,""));*/
        User user = userRepository.ConsultationPsy();
        System.out.println(user.getId());
    }
}
