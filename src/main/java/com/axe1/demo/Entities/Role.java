package com.axe1.demo.Entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Role {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id ;
    @Column(unique = true)
    @NonNull
    String name ;
}
