package org.ms.authentificationservice.entities;

import lombok.*;
import jakarta.persistence.*;
import jakarta.persistence.Entity;

import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
public class AppRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String roleName;
    // Default constructor

    // Parameterized constructor
    public AppRole(Long id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    // Optionally add additional constructors, methods, etc.
}
