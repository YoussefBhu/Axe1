package com.axe1.demo.Repositories;

import com.axe1.demo.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByUserName(String name);
    public User findByEmail(String name);
    public List<User> findUsers();
    public List<User> findPsychologues();
    @Query(nativeQuery = true ,value = "SELECT u.* FROM user AS u INNER JOIN consultation AS c ON u.id = c.psychologue_id GROUP BY c.psychologue_id ORDER BY COUNT(*) LIMIT 1")
    public User ConsultationPsy();
    public List<User> findAdmins();
}
