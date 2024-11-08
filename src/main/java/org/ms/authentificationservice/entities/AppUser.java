package org.ms.authentificationservice.entities;
import lombok.*;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<AppRole> roles = new HashSet<>();
    public AppUser(Long id, String username, String password, Set<AppRole> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }
}
